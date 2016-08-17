package com.personal.ybdesire.supermonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // root detection
        RootUtil rootutil = new RootUtil();
        String str = "Rooted: No";
        if(rootutil.isDeviceRooted())
        {
            str = "Rooted: Yes";
        }
        // display the string at TextView
        TextView t = (TextView)findViewById(R.id.rootinfo);
        t.setText(str);

        // manufacturer
        str = "Manufacturer: " + DeviceUtil.getManufacturer();
        t = (TextView)findViewById(R.id.manufacturer);
        t.setText(str);

        // device type
        str = "DeviceType: " + DeviceUtil.getDeviceType();
        t = (TextView)findViewById(R.id.devicetype);
        t.setText(str);

    }
}
