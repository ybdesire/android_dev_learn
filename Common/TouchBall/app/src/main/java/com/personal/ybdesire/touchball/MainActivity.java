package com.personal.ybdesire.touchball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get layout
        RelativeLayout root = (RelativeLayout) findViewById(R.id.root);

        // create DrawView
        final DrawView draw = new DrawView(this);

        draw.setMinimumWidth(300);
        draw.setMinimumHeight(500);

        root.addView(draw);
    }
}
