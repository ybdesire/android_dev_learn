package com.example.ybdesire.handlerthreadloop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private final int MSG_HELLO = 0;
    private Handler mHandler;
    private Thread mThread;
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(){
            public void handleMessage(Message msg){//此方法在ui线程运行
                switch(msg.what) {
                    case MSG_HELLO:
                        //display content
                        TextView xxx = (TextView)findViewById(R.id.show);
                        xxx.setText(""+msg.obj);

                }
            }
        };
        mThread = new Thread(runnable);
        mThread.start();//线程启动

    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {//run()在新的线程中运行
            while(true) {
                mHandler.obtainMessage(MSG_HELLO, "hello+" + count).sendToTarget();
                try {
                    Thread.sleep(1000);
                    count += 1;
                } catch (InterruptedException e) {
                    // Process exception
                }
            }
        }
    };
}


