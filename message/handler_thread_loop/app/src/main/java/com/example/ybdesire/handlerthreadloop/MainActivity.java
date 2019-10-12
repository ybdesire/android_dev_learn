package com.example.ybdesire.handlerthreadloop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private final int MSG_HELLO = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CustomThread().start();  //新建并启动CustomThread
        findViewById(R.id.send_btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {//点击界面时发送消息
                String str = "hello";
                Log.d("Test", "MainThread is ready to send msg:" + str);
                mHandler.obtainMessage(MSG_HELLO, str).sendToTarget();//发送消息到CustomThread实例
            }
        });
    }
    //inner class
    class CustomThread extends Thread{
        @Override
        public void run() {
            //建立消息循环的步骤
            Looper.prepare();//1、初始化Looper
            mHandler = new Handler(){//2、绑定handler到CustomThread实例的Looper对象
                public void handleMessage (Message msg) {//3、定义处理消息的方法
                    switch(msg.what) {
                        case MSG_HELLO:
                            Log.d("Test", "CustomThread receive msg:" + (String) msg.obj);
                    }
                }
            };
            Looper.loop();//4、启动消息循环
        }
    }
}


