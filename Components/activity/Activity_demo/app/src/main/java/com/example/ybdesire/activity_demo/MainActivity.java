package com.example.ybdesire.activity_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        // Do something in response to button click
        TextView txt=(TextView)findViewById(R.id.textView);//find output label by id
        txt.setText("Hello world! click by button ");

        Bundle bundle =new Bundle();// 创建  内容
        bundle.putBoolean("boolean_key", true);// 编写内容
        bundle.putString("string_key", "string_value");

        Intent intnt = new Intent(MainActivity.this, Main2Activity.class);//intent 发送的目的地 Main2Activity
        intnt.putExtra("key", bundle);// 封装bundle(要发送到另一个Activity的内容，发送的内容在另一个Activity中的onCreate()中获取)
        startActivity(intnt);//启动另一个Activity。

    }

}
