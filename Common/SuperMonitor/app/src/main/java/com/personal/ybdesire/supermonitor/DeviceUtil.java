package com.personal.ybdesire.supermonitor;
import android.os.Build;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

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

    public static String getMacAddress(){
        String macAddr = null;
        LineNumberReader reader = null;
        try{
            Process p = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            reader = new LineNumberReader(ir);
            macAddr = reader.readLine().replace(";", "");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        return macAddr==null?"":macAddr;
    }

}
