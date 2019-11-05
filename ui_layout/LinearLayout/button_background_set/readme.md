# 设置Button的背景图片

1. 新建一个btn.png图片，作为你想要的button背景，并保存到路径`button_background_set\BtnBakImage\app\src\main\res\drawable`

2. 新建一个activity_me.xml的LinearLayout

3. 拖入一个button

4. 选择drawableBottom属性为btn（btn.png图片）

完整的layout的xml如下：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:drawableBottom="@drawable/btn"
        android:text="Button" />
</LinearLayout>
```

经验：把要作为背景的图片，都放到drawable文件夹