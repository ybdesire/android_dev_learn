# 如何用baidu sdk开发地图应用

**将百度地图显示到layout中某个特定的位置**

* 参考官方文档：http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-project/ak





1. 在百度开放平台注册应用

* 参考：http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-project/ak

2. 生成签名

```
keytool -genkey -alias ybdesire.keystore -keyalg RSA -validity 20000 -keystore ybdesire.key
```

3. 查看签名hash

```
keytool -list -v -keystore ybdesire.key
```

4. 配置android studio

* http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-project/androidstudio

5. manifest中添加meta-data

```
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <meta-data
            android:name="com.baidu.lbsapi.API_KEY"
            android:value="xv4R8Pf2rK5zU4RV2im562uxE5KPl5kZ" />

    </application>
```


6. 添加权限

baidu官网上写的不够全

```
    <uses-permission android:name="com.android.launcher.permission.READ_SETTINGS" />
    <!-- 这个权限用于进行网络定位 -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <!-- 这个权限用于访问GPS定位 -->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <!-- 用于访问wifi网络信息，wifi信息会用于进行网络定位 -->
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <!-- 获取运营商信息，用于支持提供运营商信息相关的接口 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <!-- 用于读取手机当前的状态 -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <!-- 写入扩展存储，向扩展卡写入数据，用于写入离线定位数据 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- 访问网络，网络定位需要上网 -->
    <uses-permission android:name="android.permission.INTERNET" />
```

7. 其他关键代码

* http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-map/showmap


注意：
* 一定要新建一个class DemoApplication extends Application，并严格按照官网上的要求来AndroidManifest.xml文件中声明该Application
* 将`com.baidu.mapapi.map.MapView`写到任何你想显示的layout中，就能显示地图
* 需要手动在手机上为APP授予权限


8. 最终效果

![alt tag](screenshot.png)


