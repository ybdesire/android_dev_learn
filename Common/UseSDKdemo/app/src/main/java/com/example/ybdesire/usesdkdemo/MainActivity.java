package com.example.ybdesire.usesdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get string from class SdkHello member function
        SdkHello sh = new SdkHello();
        String str = sh.getStr();
        // display the string at TextView
        TextView t = (TextView)findViewById(R.id.texto);
        t.setText(str);
    }
}
