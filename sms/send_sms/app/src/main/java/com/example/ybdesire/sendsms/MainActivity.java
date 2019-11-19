package com.example.ybdesire.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms_1);

        // 3 button for 3 methods
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);

        // get phonenum & txt
        EditText e_phone_num = findViewById(R.id.et_phonenum);
        EditText e_txt_msg = findViewById(R.id.et_txtmsg);
        final String phone_num = e_phone_num.getText().toString();
        final String txt_msg = e_txt_msg.getText().toString();

        // click listener
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    // Your code.
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone_num, null, txt_msg, null, null);
                    Log.d("send sms", "button1 clicked， phone_num = " + phone_num + " msg = " + txt_msg);
                }catch(Exception e)
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast1.show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                // Your code.
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra(phone_num,"your desired phoneNumber");
                smsIntent.putExtra(txt_msg,"your desired message");
                startActivity(smsIntent);

                Log.d("send sms", "button2 clicked， phone_num = " + phone_num + " msg = " + txt_msg);
                }catch(Exception e)
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                // Your code.
                Uri uriSms = Uri.parse("smsto:"+phone_num);
                Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uriSms);
                intentSMS.putExtra(txt_msg, "The SMS text");
                startActivity(intentSMS);

                Log.d("send sms", "button3 clicked， phone_num = " + phone_num + " msg = " + txt_msg);
                }catch(Exception e)
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

    }
}
