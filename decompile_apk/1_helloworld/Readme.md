**Deompile apk to Smali**

* Install Apktool 2.0 at windows10: http://ibotpeaches.github.io/Apktool/install/
* Copy apk file from AndroidAPPLearnAndroidAPPLearn\HelloWorld\app\app-release.apk to current path.
* Run apktool and get the decompiled Smali files.(The decompiled files at dir `app-release`)

```
apktool d app-release.apk
```


**Modify Smali, and build new APK**

* Original button click will display "Hello world! click by button 2". Search this string and modified to "de-compile test". 
* Compile the Smali files to apk.

```
apktool b app-release -o app-decompile.apk
```

* Currently we get the app-decompile.apk, but it cannot be installed at Android device since there is no signature for this apk.


**Signature**

* Move the `keystore` file from `AndroidAPPLearn\HelloWorld\sign` to current dir.
* Signature the `app-decompile.apk` by cmd below.


```
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore sign.jks app-decompile.apk test
```


**Install and get result**

* Install signed `app-decompile.apk`, run, and click button: the orginal string "Hello world! click by button 2" is changed to  "de-compile test"


**参考**

* [1] APK签名过程， http://stackoverflow.com/questions/21457538/how-to-use-jarsigner-for-signing-an-apk
* [2] `app-release.apk`签名过程: `AndroidAPPLearn\HelloWorld\Readme.md`

