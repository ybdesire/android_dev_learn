package com.personal.ybdesire.supermonitor;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

/**
 * Created by ybdesire on 2016/8/17.
 * Get device/system properties
 */
public class DeviceUtil {
    /*
    * such as HUAWEI
    * */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /*
    * such as HUAWEINXT-DL00
    * */
    public static String getDeviceType() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }


    public static String getAndroidOSVersion()
    {
        String ver = Build.VERSION.RELEASE;
        return ver;
    }



}
