# how to add navigation bar


1. add to `app/build.gradle` for 3rd lib

```
    implementation 'me.majiajie:pager-bottom-tab-strip:+'
```


2. add to layout (between LinearLayout) for nav-bar creation

```
<me.majiajie.pagerbottomtabstrip.PageNavigationView
        android:id="@+id/tab"
        android:elevation="8dp"
        android:layout_width="match_parent"
        android:layout_height="56dp"
        android:layout_alignParentBottom="true"
        android:background="#FFF"
        />
```

details: app\src\main\res\layout\activity_main.xml


3. add to activity for nav-bar-items & listener

```
PageNavigationView tab = (PageNavigationView) findViewById(tab);

NavigationController navigationController = tab.material()
        .addItem(android.R.drawable.ic_menu_camera, "相机")
        .addItem(android.R.drawable.ic_menu_compass, "位置")
        .addItem(android.R.drawable.ic_menu_search, "搜索")
        .addItem(android.R.drawable.ic_menu_help, "帮助")
        .build();

// Listener
navigationController.addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
	@Override
	public void onSelected(int index, int old) {
		TextView txt = findViewById(R.id.textView);
		txt.setText(""+index+","+old);
	}
});

```


4. ref

* https://github.com/tyzlmjj/PagerBottomTabStrip/wiki/V2_%E5%BF%AB%E9%80%9F%E6%9E%84%E5%BB%BA



