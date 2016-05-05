# Intro
   * Activities
      * 有UI的单个screen
      * 多个activities组成一个完整的UI
      * 比如email应用有这样一些activity：email列表界面，email输入界面，email阅读界面。一个界面就是一个activity
   * Activity 的生命周期交给系统统一管理


# Activity 的状态及状态间的转换

* `Active/Runing`: 一个新 Activity 启动入栈后，它在屏幕最前端，处于栈的最顶端，此时它处于可见并可和用户交互的激活状态。
* `Paused`: 当 Activity 被另一个透明或者 Dialog 样式的 Activity 覆盖时的状态。此时它依然与窗口管理器保持连接，系统继续维护其内部状态，所以它仍然可见，但它已经失去了焦点故不可与用户交互。
* `Stoped`: 当 Activity 被另外一个 Activity 覆盖、失去焦点并不可见时处于 Stoped状态。
* `Killed`: Activity 被系统杀死回收或者没有被启动时处于 Killed状态。

# Activity 生命周期

```java
 public class OurActivity extends Activity { 
    protected void onCreate(Bundle savedInstanceState); 
    protected void onStart(); 
    protected void onResume(); 
    protected void onPause(); 
    protected void onStop(); 
    protected void onDestroy(); 
 }
```

# 启动另外一个 Activity

在MainActivity中启动Main2Activity

```java
Intent intnt = new Intent(MainActivity.this, Main2Activity.class);
startActivity(intnt);
```

# Activity 之间通信

用intent实现，MainActivity发送信息到Main2Activity。在MainActivity中需添加发送消息内容。

```java
Bundle bundle =new Bundle();// 创建内容
bundle.putBoolean("boolean_key", true);// 编写内容
bundle.putString("string_key", "string_value");

Intent intnt = new Intent(MainActivity.this, Main2Activity.class);//intent 发送的目的地 Main2Activity
intnt.putExtra("key", bundle);// 封装bundle(要发送到另一个Activity的内容，发送的内容在另一个Activity中的onCreate()中获取)
startActivity(intnt);//启动另一个Activity (Main2Activity)。
```

在Main2Activity的onCreate()或者其它任何地方使用下面的代码就可以读取MainActivity发送的信息。

```java
Intent intent =getIntent();// 收取MainActivity发送的信息
Bundle bundle =intent.getBundleExtra("key");// 打开
Boolean msg_1 =  bundle.getBoolean("boolean_key");// 读取内容
String msg_2 = bundle.getString("string_key");
Log.d("myTag", msg_2);
```

通过log就能查看到消息
```
05-05 15:57:46.137 12716-12716/com.example.ybdesire.activity_demo D/myTag: string_value
```

# AndroidManifest.xml

指定程序首次启动的Activity（通过`action`和`category`）

```xml
<activity android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

添加一个activity（`Main2Activity`）后，manifest文件中也会添加相应内容

```xml
<activity
    android:name=".Main2Activity"
    android:label="@string/title_activity_main2"
    android:theme="@style/AppTheme.NoActionBar">
</activity>
```

# Ref
1. https://www.ibm.com/developerworks/cn/opensource/os-cn-android-actvt/
2. https://developer.android.com/guide/components/fundamentals.html#Components