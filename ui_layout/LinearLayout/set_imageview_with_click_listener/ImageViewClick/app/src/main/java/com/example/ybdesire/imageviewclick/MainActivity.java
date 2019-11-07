package com.example.ybdesire.imageviewclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ImageView iv = findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Your code.
                Log.d("imageviewtest", "ImageView clicked");
            }
        });
    }
}
