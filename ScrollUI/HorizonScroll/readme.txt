# Horizon Scroll

1. `HorizontalScrollView` outside of `LinearLayout`.
2. do not add `constraintlayout` inside of `HorizontalScrollView`, since the widget cannot be setted.


```

<HorizontalScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <Button
            android:id="@+id/button44"
            android:layout_width="1000dp"
            android:layout_height="wrap_content"
            android:text="123456aosdng'adflajsodifjaslkdnflakdfjlakjsdflasdnflwejijvlaivla894#$%GWSfsdfbs" />


    </LinearLayout>

</HorizontalScrollView>


```





# ref

* https://juejin.im/post/5d5e8b30518825731553afe6
