# Vertical Scroll

1. `ScrollView` outside of `LinearLayout`.
2. do not add `constraintlayout` inside of `ScrollView`, since the widget cannot be setted.
3. `android:fillViewport="true"` is important

```

<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fadingEdge="vertical"
    android:scrollbars="vertical"
    android:fillViewport="true">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="237dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button3"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="203dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button4"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button6"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="62dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button5"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="62dp"
            android:orientation="vertical">

            <Button
                android:id="@+id/button8"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Button" />
        </LinearLayout>
    </LinearLayout>
</ScrollView>



```





# ref

* https://juejin.im/post/5d5e8b30518825731553afe6
