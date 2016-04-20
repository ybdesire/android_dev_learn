package com.example.biny.privatesharefile;

import com.example.biny.privatesharefile.ShareFileAPI;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.util.Log;

import java.io.*;
import org.json.*;

import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private ArrayList<String> fileIdList;
    private ArrayList<String> fileNameList;
    private RadioGroup fileGrp;
    private ShareFileAPI sfapi;
    private String homeFolderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileIdList=new ArrayList<String>();
        fileNameList=new ArrayList<String>();
        homeFolderID=null;
        sfapi = new ShareFileAPI("citrite", "sharefile.com");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void updateFileListView(View target)
    {
        updateHomeList();
    }
    public void updateHomeList()
    {
        JSONArray jsonDataArry = sfapi.getFolderListByID("home");
        displayFilesAtLayout(jsonDataArry);
    }
    public void login(View target)//button event
    {
        String username = ((EditText)findViewById(R.id.userNameInput)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordInput)).getText().toString();

        TextView outPut = (TextView)findViewById(R.id.textView5);


        if(sfapi.oAuth(username, password)==true)
        {
            outPut.setTextColor(Color.GREEN);
            outPut.setText("Pass");
            updateHomeList();
            //setContentView(R.layout.fileslist);

        }
        else
        {
            outPut.setTextColor(Color.RED);
            outPut.setText("Invalid username or password!");
        }
    }

    public void displayFilesAtLayout(JSONArray items)
    {
        setContentView(R.layout.fileslist);
        ScrollView sview = (ScrollView)findViewById(R.id.scrollView);
        fileGrp = new RadioGroup(this);

        try {
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = (JSONObject) items.get(i);
                //get home id
                if(item.get("parentname").toString().compareTo("My Files & Folders")==0)
                {
                    homeFolderID = item.get("parentid").toString();
                }
                fileIdList.add(i, item.get("id").toString());
                fileNameList.add(i, item.get("displayname").toString());
                //System.out.println(item.get("id") + " " + item.get("displayname") + " " + item.get("creationdate") + " " + item.get("type"));
                RadioButton rb = new RadioButton(this);
                rb.setId(i);
                rb.setText(item.get("type").toString() + ": " + item.get("displayname"));
                fileGrp.addView(rb);
            }
            sview.addView(fileGrp);

        }
        catch (JSONException je)
        {

        }

    }

    public void downloadFile(View target)//button event
    {
        RadioButton selectedFile = (RadioButton)findViewById(fileGrp.getCheckedRadioButtonId());
        String fileID=fileIdList.get(fileGrp.getCheckedRadioButtonId());
        String fileName = fileNameList.get(fileGrp.getCheckedRadioButtonId());
        String downloadURl = sfapi.getFileDownloadLink(fileID);
        String path = Environment.getExternalStorageDirectory().toString()+"/BinYin/"+fileName;
        File fullDir = new File(path);
        sfapi.downloadFileByLink(downloadURl, fullDir.toString());
    }

    public void uploadFile(View target)
    {
        selectFile();
    }

    public void selectFile()
    {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Choose File"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)//for file upload
    {
        if(resultCode==RESULT_CANCELED)
        {
            // action cancelled
        }
        if(resultCode==RESULT_OK)
        {
            String selectedFile = data.getData().getPath();
            if(sfapi.fileUploadToHome(selectedFile, homeFolderID)==true)
            {
                ((TextView)findViewById(R.id.textView8)).setText("file upload ok");
            }
            else
            {
                ((TextView)findViewById(R.id.textView8)).setText("cannot upload this file");
            }
        }
    }

    //-------function test----------------------------------------------------------

    public void getFilesAtDir()
    {
        String path = Environment.getExternalStorageDirectory().toString()+"/Download";
        File f = new File(path);
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "FileName:" + file[i].getName());
        }
    }

    public void downloadFileFromURL(String url)
    {
        String path = Environment.getExternalStorageDirectory().toString()+"/Download";
        File f = new File(path);
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "FileName:" + file[i].getName());
        }
    }

    public void createDir(String dir)
    {
        String path = Environment.getExternalStorageDirectory().toString()+dir;
        File fullDir = new File(path);
        boolean success = fullDir.mkdirs();
    }

    public String getContentFromURL(String requrl)
    {
        URL url=null;
        try {
            url = new URL(requrl);
        }
        catch (MalformedURLException ex)
        {
            return null;
        }

        try {
            if(url!=null)
            {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
                {

                }
            }
        }
        catch(IOException ex)
        {
            return null;
        }
        return null;
    }

    public void setLayout(View target)
    {
        setContentView(R.layout.fileslist);
        ScrollView sview = (ScrollView)findViewById(R.id.scrollView);
        RadioGroup rgrp = new RadioGroup(this);

        for (int i=0;i<40;i++)
        {
            RadioButton rb = new RadioButton(this);
            rb.setText("my radio " + i);
            rgrp.addView(rb);
        }
        sview.addView(rgrp);


    }

    public void arraylistTest()
    {
        ArrayList<String> as = new ArrayList<String>();
        as.add(0, "0asdfasdfasdf");
        as.add(1, "1asdfasdfasdf");
        as.add(2, "2asdfasdfasdf");
        as.add(3, "3asdfasdfasdf");
        as.add(4, "4asdfasdfasdf");
        as.add(5, "5asdfasdfasdf");
        as.add(6, "6asdfasdfasdf");
        as.add(7, "7asdfasdfasdf");
        as.add(8, "8asdfasdfasdf");
        as.add(9, "9asdfasdfasdf");
    }

}
