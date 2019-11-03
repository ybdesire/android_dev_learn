# 如何用LinearLayout实现两个button放置在任意位置（Layout Design布局）


1. 新建一个Layout（LinearLayout）

* [**activity_me.xml**](TwoBtnAnyLocation/app/src/main/res/layout/activity_me.xml)


2. 在Design界面

* 首先拖入一个LinearLayout(Vertical) A 打底
* 再拖入一个LinearLayout(Vertical) B，将B放置在A上，还可以调整B的下边界宽度
* 再拖入一个LinearLayout(Vertical) C，将B放置在A上，此时C的上边界和B对齐，形成了类似矩阵的第二行位置。还可以调整C的下边界宽度，就调整了第二行的高度
* 依次类推，可以拖入D,E

* 接下来，拖入一个LinearLayout(horizontal) B1, 放在B上 （注意：这个和B重合的B1，一定要有，不能省略，很重要）
* 拖入一个LinearLayout(horizontal) B2, 放在B1上，此时可以调整B2右边界宽度
* 拖入一个LinearLayout(horizontal) B3, 放在B1上，此时B3左边界与B2右边界对齐，此时可以调整B3右边界宽度
* 从而实现B2, B3在一个水平面的左右不同部分
* 以此类推，拖入C2,C3
* 在将button放在B2，C3区域，就实现了button在任意不同的位置





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
            android:layout_height="178dp"
            android:orientation="vertical">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">

                <LinearLayout
                    android:layout_width="152dp"
                    android:layout_height="match_parent"
                    android:orientation="horizontal">

                    <Button
                        android:id="@+id/button"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:text="Button" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="horizontal"></LinearLayout>
            </LinearLayout>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="182dp"
            android:orientation="vertical">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">

                <LinearLayout
                    android:layout_width="262dp"
                    android:layout_height="match_parent"
                    android:orientation="horizontal"></LinearLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="horizontal">

                    <Button
                        android:id="@+id/button2"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:text="Button" />
                </LinearLayout>
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>
</LinearLayout>


```