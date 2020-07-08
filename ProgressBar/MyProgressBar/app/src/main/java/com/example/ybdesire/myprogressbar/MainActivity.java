package com.example.ybdesire.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler=new Handler();
        Runnable r=new Runnable() {
            public void run() {
                //what ever you do here will be done after 3 seconds delay.
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(myIntent);

            }
        };
        handler.postDelayed(r, 3000);
    }
}
