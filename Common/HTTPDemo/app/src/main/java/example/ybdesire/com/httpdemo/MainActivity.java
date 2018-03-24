package example.ybdesire.com.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class MainActivity extends AppCompatActivity {
    private void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.button_get);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        try {

                            //Your code goes here
                            String url = "http://www.baidu.com";
                            HttpClient httpclient = new DefaultHttpClient();
                            HttpGet httpget = new HttpGet(url);


                            Log.d("myapp", "works till here. 2");
                            try {
                                HttpResponse response = httpclient.execute(httpget);
                                String responseBody = EntityUtils.toString(response.getEntity());
                                TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                setText(txtOutput, responseBody);
                                Log.d("myapp", "response " + responseBody);
                            } catch (ClientProtocolException e) {
                                e.printStackTrace();
                                TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                setText(txtOutput, "network error");
                            } catch (IOException e) {
                                e.printStackTrace();
                                TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                setText(txtOutput, "network error");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
            }
        });


        // compile
        btn=findViewById(R.id.button_post);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        try {

                            //Your code goes here
                            String code = "public class Main//should be Main here\n{\n    public static void main(String[] arg)\n    {\n        System.out.println(\"hello world\");\n    }\n }";
                            String url = "http://45.79.179.111/java-android/compile_android.php";
                            HttpClient httpclient = new DefaultHttpClient();
                            HttpPost httppost = new HttpPost(url);
                            // Add your data
                            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
                            nameValuePairs.add(new BasicNameValuePair("source", code));
                            nameValuePairs.add(new BasicNameValuePair("input", "0"));

                            try {
                                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));


                                Log.d("myapp", "works till here. 2");
                                try {
                                    HttpResponse response = httpclient.execute(httppost);
                                    String responseBody = EntityUtils.toString(response.getEntity());
                                    TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                    setText(txtOutput, responseBody);
                                    Log.d("myapp", "response " + responseBody);
                                } catch (ClientProtocolException e) {
                                    e.printStackTrace();
                                    TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                    setText(txtOutput, "network error");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                    setText(txtOutput, "network error");
                                }
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                TextView txtOutput = findViewById(R.id.txt);//find output label by id
                                setText(txtOutput, "network error");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            TextView txtOutput = findViewById(R.id.txt);//find output label by id

                            txtOutput.setText("network error");
                        }
                    }
                });

                thread.start();
            }});

    }
}
