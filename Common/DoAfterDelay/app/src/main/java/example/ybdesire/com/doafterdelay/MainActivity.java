package example.ybdesire.com.doafterdelay;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button click listener
        Button btn=findViewById(R.id.button_click);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // disable the button
                Button btnc=findViewById(R.id.button_click);
                btnc.setClickable(false);
                btnc.setBackgroundColor(Color.GRAY);
                //timer for 5s delay and enable button
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Button btncc=findViewById(R.id.button_click);
                        btncc.setClickable(true);//enable the button after 5s
                        btncc.setBackgroundResource(android.R.drawable.btn_default);
                    }
                }, 5000);

            }
        });


    }
}
