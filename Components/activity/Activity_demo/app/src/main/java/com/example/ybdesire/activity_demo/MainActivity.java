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
        Intent intnt = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intnt);

    }

}
