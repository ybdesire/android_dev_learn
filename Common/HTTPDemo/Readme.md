# steps to use HTTP request


* (1) Add `useLibrary 'org.apache.http.legacy'` to build.gradle of Module app, as below.

```
android {
    useLibrary 'org.apache.http.legacy'
    compileSdkVersion 26
    defaultConfig {
        applicationId "example.ybdesire.com.httpdemo"
        minSdkVersion 15
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

```


* (2) Add below import statement to .java


```
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
```


* (3) Add permission `<uses-permission android:name="android.permission.INTERNET" />` to `AndroidManifest.xml` as below


```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="example.ybdesire.com.httpdemo">
    <uses-permission android:name="android.permission.INTERNET" />
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```


* (4) Click button and HTTP GET request code below

```
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
```


* (5) Click button and HTTP POST request code below

```
btn=findViewById(R.id.button_post);
btn.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {

            try {

                //Your code goes here
                String url = "http:sample_url";
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(url);
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
                nameValuePairs.add(new BasicNameValuePair("source", "data-1-here"));//key-value
                nameValuePairs.add(new BasicNameValuePair("input", "data-2-here"));//key-value

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

```
