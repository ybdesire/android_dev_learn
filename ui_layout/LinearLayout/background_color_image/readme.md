# 改变Layout背景颜色和背景图片


1. 新建一个layout（activity_me.xml）
* LinearLayout

2. 背景颜色：在UI Design的attributes选择background想要的具体颜色

最终得到的layout完整xml如下

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#8BC34A"
    android:orientation="vertical">

</LinearLayout>
```

3. 设置默认资源为背景图片：拖动一个ImageView控件到LinearLayout上，再为其选择默认/自带的drawable资源


4. 设置pgn为背景图

* 将一张png图片，保存到`BackgroundColorImage\app\src\main\res\drawable`路径下为`BackGround.png`图片
* 拖动一个ImageView控件到LinearLayout上
* 鼠标选择ImageView的srcCompat属性，再选择Drawable->Project->BackGround

最终layout的xml为

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#8BC34A"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="816dp"
        tools:srcCompat="@drawable/BackGround" />
</LinearLayout>
```
