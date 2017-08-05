package com.personal.ybdesire.supermonitor;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_STATE = 1;
//    private void checkForPhoneStatePermission(){
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            if (ContextCompat.checkSelfPermission(MainActivity.this,
//                    Manifest.permission.READ_PHONE_STATE)
//                    != PackageManager.PERMISSION_GRANTED) {
//
//                // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                        Manifest.permission.READ_PHONE_STATE)) {
//
//                    // Show an explanation to the user *asynchronously* -- don't block
//                    // this thread waiting for the user's response! After the user
//                    // sees the explanation, try again to request the permission.
//
//                    showPermissionMessage();
//
//                } else {
//
//                    // No explanation needed, we can request the permission.
//                    ActivityCompat.requestPermissions(MainActivity.this,
//                            new String[]{Manifest.permission.READ_PHONE_STATE},
//                            REQUEST_PHONE_STATE);
//                }
//            }
//        }else{
//            //... Permission has already been granted, obtain the UUID
//            getDeviceUuId(MainActivity.this);
//        }
//
//    }else{
//        //... No need to request permission, obtain the UUID
//        getDeviceUuId(MainActivity.this);
//    }
//}


    private void showPermissionMessage(){
        new AlertDialog.Builder(this)
                .setTitle("Read phone state")
                .setMessage("This app requires the permission to read phone state to continue")
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.READ_PHONE_STATE},
                                REQUEST_PHONE_STATE);
                    }
                }).create().show();
    }

    ////
/*    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case REQUEST_PHONE_STATE:

                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    // .. Can now obtain the UUID
                    getDeviceUuId(MainActivity.this);
                }else{
                    Toast.makeText(MainActivity.this, "Unable to continue without granting permission", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPermissionMessage();

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

        // mac address
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        String mac = wInfo.getMacAddress();
        str = "MAC address: " + mac;
        t = (TextView)findViewById(R.id.macaddr);
        t.setText(str);

        // OS version
        str = "Android version: " + DeviceUtil.getAndroidOSVersion();
        t = (TextView)findViewById(R.id.osver);
        t.setText(str);


        // device id
        TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String devid = mTelephonyMgr.getDeviceId();
        String imsi = mTelephonyMgr.getSubscriberId();
        String areacode = mTelephonyMgr.getSimCountryIso();
        String ope = mTelephonyMgr.getSimOperator();
        str = "device_id: " + devid + " imsi: " + imsi + " areacode: " + areacode + " telecomsOperator: " + ope;
        t = (TextView)findViewById(R.id.devid);
        t.setText(str);


        Button btn=(Button)findViewById(R.id.btn_sys_sec);//find button by id(defined at activity_main.xml)
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intnt = new Intent(MainActivity.this, SysSecActivity.class);
                startActivity(intnt);
            }
        });

    }
}
