# 如何用LinearLayout实现两个button放置在任意位置（Layout Design布局）


1. 新建一个Layout（LinearLayout）

* [**activity_me.xml**](app/src/main/res/layout/activity_me.xml)


2. 在Design界面

* 首先拖入一个LinearLayout(Vertical) A 打底
* 再拖入一个LinearLayout(Vertical) B，将B放置在A上，还可以调整B的下边界宽度
* 再拖入一个LinearLayout(Vertical) C，将B放置在A上，此时C的上边界和B对齐，形成了类似矩阵的第二行位置。还可以调整C的下边界宽度，就调整了第二行的高度
* 依次类推，可以拖入D,E


3. 最终layout.xml布局


```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="152dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="165dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="187dp"
            android:orientation="vertical"></LinearLayout>
    </LinearLayout>
</LinearLayout>
```