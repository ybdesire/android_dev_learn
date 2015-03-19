package com.example.biny.privatesharefile;

import android.net.Uri;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by biny on 3/17/2015.
 */
public class ShareFileAPI {
    private String subdomain;
    private String tld;
    private String authId;

    public ShareFileAPI(String sub_domain, String stld)
    {
        subdomain = sub_domain;
        tld=stld;
    }

    public boolean oAuth(String username, String password)
    {
        String requestUrl = String.format("https://%s.%s/rest/getAuthID.aspx?fmt=json&username=%s&password=%s",
                subdomain, tld, Uri.encode(username), Uri.encode(password));
        JSONObject jsonData = invokeShareFileOperation(requestUrl);
        try {
            if (jsonData != null && jsonData.getString("error").compareTo("false") == 0)
            {
                this.authId=jsonData.getString("value");
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(JSONException ex)
        {
            //TextView outPut = (TextView)findViewById(R.id.textView5);
            //outPut.setTextColor(Color.RED);
            //outPut.setText(ex.toString());
            return false;
        }
    }

    public JSONArray getFolderListByID(String id)//"id=home"
    {
        if (id.isEmpty()) {
            id = "/";
        }

        HashMap<String, Object> requiredParameters = new HashMap<String, Object>();
        requiredParameters.put("id", id);

        String url = this.buildUrl("folder", "list", requiredParameters);
        System.out.println(url);

        JSONObject jsonObj = this.invokeShareFileOperation(url);
        try {
            boolean error = (boolean) jsonObj.get("error");
            if (!error) {
                JSONArray items = (JSONArray) jsonObj.get("value");
                if (items.length() == 0) {
                    return null;
                }
                return items;
            } else {
                long errorCode = (long) jsonObj.get("errorCode");
                String errorMessage = (String) jsonObj.get("errorMessage");
                System.out.println(errorCode + " : " + errorMessage);
                return null;
            }
        }
        catch(JSONException je)
        {
            return null;
        }
    }

    public String getFileDownloadLink(String fileId)
    {
        HashMap<String, Object> requiredParameters = new HashMap<String, Object>();
        requiredParameters.put("id", fileId);

        String url = this.buildUrl("file", "download", requiredParameters);
        JSONObject jsonData = invokeShareFileOperation(url);
        try {
            if (jsonData != null && jsonData.getString("error").compareTo("false") == 0)
            {
                return jsonData.getString("value");
            }
            else
            {
                return null;
            }
        }
        catch(JSONException ex)
        {
            return null;
        }
    }

    public boolean downloadFileByLink(String downloadUrl, String localPath)//local file path
    {
        BufferedInputStream source = null;
        FileOutputStream target = null;
        try {
            source = new BufferedInputStream(new URL(downloadUrl).openStream());
            target = new FileOutputStream(localPath);

            byte chunk[] = new byte[8192];
            int len;
            while ((len = source.read(chunk, 0, 8192)) != -1)
            {
                target.write(chunk, 0, len);
            }
            source.close();
            target.close();
            return true;
        }
        catch(IOException ioe){
            return false;
        }
    }

    public boolean fileUploadToHome(String localPath, String homeFolderID)//local file path
    {
        HashMap<String, Object> requiredParameters = new HashMap<String, Object>();
        requiredParameters.put("filename", new File(localPath).getName());
        HashMap<String, Object> optionalParameters = new HashMap<String, Object>();
        optionalParameters.put("folderid", homeFolderID);

        String url = this.buildUrl("file", "upload", requiredParameters, optionalParameters);
        System.out.println(url);

        JSONObject jsonObj = this.invokeShareFileOperation(url);
        try {
            boolean error = (boolean) jsonObj.get("error");
            if (!error) {
                String uploadUrl = (String) jsonObj.get("value");
                System.out.println("uploadUrl = " + uploadUrl);
                this.multipartUploadFile(localPath, uploadUrl);
                return true;
            } else {
                long errorCode = (long) jsonObj.get("errorCode");
                String errorMessage = (String) jsonObj.get("errorMessage");
                System.out.println(errorCode + " : " + errorMessage);
                return false;
            }
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    private void multipartUploadFile(String localPath, String uploadUrl)
            throws MalformedURLException, IOException
    {
        URL url = new URL(uploadUrl);
        URLConnection connection = url.openConnection();

        String boundary = "--"+ UUID.randomUUID().toString();

        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        File file = new File(localPath);
        String filename = file.getName();

        InputStream source = new FileInputStream(file);
        OutputStream target = connection.getOutputStream();

        StringBuffer buffer = new StringBuffer();
        buffer.append("--"+boundary+"\r\n");
        buffer.append("Content-Disposition: form-data; name=File1; filename=\""+filename+"\"\r\n");
        String contentType = URLConnection.guessContentTypeFromName(filename);
        if (contentType == null) { contentType = "application/octet-stream"; }
        buffer.append("Content-Type: "+contentType+"\r\n\r\n");

        target.write(buffer.toString().getBytes());

        // read from file, and write to outputstream
        byte[] buf = new byte[1024*1024];
        int len;
        while((len = source.read(buf, 0, buf.length)) >= 0) {
            target.write(buf, 0, len);
        }
        target.flush();

        target.write(("\r\n--"+boundary+"--\r\n").getBytes());

        // get Response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }
        reader.close();
        System.out.println(response.toString());

        target.close();
        source.close();
    }

    private JSONObject invokeShareFileOperation(String requestUrl)
    {
        URL url=null;

        try
        {
            url = new URL(requestUrl);
        }
        catch(MalformedURLException ex)
        {
            return null;
        }

        try
        {
            URLConnection connection = url.openConnection();
            connection.setReadTimeout(3000);
            connection.setReadTimeout(3000);
            connection.connect();
            InputStream is = connection.getInputStream();
            int read = -1;
            byte[] inbuffer = new byte[4096];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ((read = is.read(inbuffer)) != -1) {
                baos.write(inbuffer, 0, read);
            }

            byte[] b = baos.toByteArray();
            is.close();

            String str = new String(b);

            try
            {
                JSONObject jsonData = new JSONObject(str);
                return jsonData;
            }
            catch(JSONException ex)
            {
                return null;
            }
        }
        catch(IOException ex)
        {
            return null;
        }
    }

    private String buildUrl(String endpoint, String op, HashMap<String, Object> requiredParameters)
    {
        return this.buildUrl(endpoint, op, requiredParameters, new HashMap<String, Object>());
    }

    private String buildUrl(String endpoint, String op, HashMap<String, Object> requiredParameters, HashMap<String, Object> optionalParameters)
    {
        requiredParameters.put("authid", this.authId);
        requiredParameters.put("op", op);
        requiredParameters.put("fmt", "json");
        ArrayList<String> parameters = new ArrayList<String>();
        StringBuilder urlParameters = new StringBuilder();

        try {
            for (Map.Entry<String, Object> entry : requiredParameters.entrySet()) {
                parameters.add(String.format("%s=%s", entry.getKey(), URLEncoder.encode(entry.getValue().toString(), "UTF-8")));
            }
            for (Map.Entry<String, Object> entry : optionalParameters.entrySet()) {
                parameters.add(String.format("%s=%s", entry.getKey(), URLEncoder.encode(entry.getValue().toString(), "UTF-8")));
            }

            String separator = "";

            for(String param : parameters) {
                urlParameters.append(separator);
                urlParameters.append(param);
                separator = "&";
            }
        }
        catch (UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }
        String url = String.format("https://%s.%s/rest/%s.aspx?%s", this.subdomain, this.tld, endpoint, urlParameters);
        return(url);
    }

    public void folderListByID(String id)
    {
        if (id.isEmpty()) {
            id = "/";
        }

        HashMap<String, Object> requiredParameters = new HashMap<String, Object>();
        requiredParameters.put("id", id);

        String url = this.buildUrl("folder", "list", requiredParameters);
        System.out.println(url);

        JSONObject jsonObj = this.invokeShareFileOperation(url);
        try {
            boolean error = (boolean) jsonObj.get("error");
            if (!error) {
                JSONArray items = (JSONArray) jsonObj.get("value");
                if (items.length() == 0) {
                    System.out.println("No 	Results");
                }

                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = (JSONObject) items.get(i);
                    System.out.println(item.get("id") + " " + item.get("displayname") + " " + item.get("creationdate") + " " + item.get("type"));
                }
            } else {
                long errorCode = (long) jsonObj.get("errorCode");
                String errorMessage = (String) jsonObj.get("errorMessage");
                System.out.println(errorCode + " : " + errorMessage);
            }
        }
        catch(JSONException je)
        {

        }
    }

    /**
     * Prints out a folder list for the specified path or root if none is provided.
     *
     * Currently prints out id, filename, creationdate, type.
     *
     * @param path folder to list
     */
    public void folderList(String path)
    {
        if (path.isEmpty()) {
            path = "/";
        }

        HashMap<String, Object> requiredParameters = new HashMap<String, Object>();
        requiredParameters.put("path", path);

        String url = this.buildUrl("folder", "list", requiredParameters);
        System.out.println(url);

        JSONObject jsonObj = this.invokeShareFileOperation(url);
        try {
            boolean error = (boolean) jsonObj.get("error");
            if (!error) {
                JSONArray items = (JSONArray) jsonObj.get("value");
                if (items.length() == 0) {
                    System.out.println("No 	Results");
                }

                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = (JSONObject) items.get(i);
                    System.out.println(item.get("id") + " " + item.get("displayname") + " " + item.get("creationdate") + " " + item.get("type"));
                }
            } else {
                long errorCode = (long) jsonObj.get("errorCode");
                String errorMessage = (String) jsonObj.get("errorMessage");
                System.out.println(errorCode + " : " + errorMessage);
            }
        }
        catch(JSONException je)
        {

        }
    }





}
