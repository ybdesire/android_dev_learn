# 让ImageView控件能响应用户点击


1. 新建控件背景图片`cat.png`，保存到`ImageViewClick\app\src\main\res\drawable`

2. 新建LinearLayout，命名为activity_me.xml

3. 在这个LinearLayout上，拖入ImageView，插入`cat.png`作为ImageView的背景图片

此时layout的xml为

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/mycat" />
</LinearLayout>
```

4. 在MainActivity中，添加如下代码，为imageView添加setOnClickListener

```
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
```

5. 点击ImageView中的cat，就能在Logcat中看到内容

