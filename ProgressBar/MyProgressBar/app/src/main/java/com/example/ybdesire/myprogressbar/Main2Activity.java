package com.example.ybdesire.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {
    private int cnt  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
                cnt++;
                pb.setProgress(cnt);

            }

        });
    }
}
