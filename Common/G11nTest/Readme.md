# Android App G11n Steps


* Add all hard codded strings to `app/src/main/res/values/strings.xml`.

```
<resources>
    <string name="app_name">G11nTest</string>
    <string name="title">The 2018 Oscar winners have been announced!</string>
    <string name="btn">Hello</string>
</resources>
```


* Create g11n string folders.
   * `app/src/main/res/values-zh/strings.xml`
   * `app/src/main/res/values-de/strings.xml`
   * `app/src/main/res/values-jp/strings.xml`
   * `app/src/main/res/values-fr/strings.xml`


* Using strings at layout(`app/src/main/res/layout/activity_main.xml`) as below.

```
android:text="@string/title"
```


* Using strings at java code by `R.string.btn` as below.

```
txt.setText(R.string.btn);
```