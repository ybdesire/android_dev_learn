
## Compile .java to .smali

* 1. Compile .java to .class by cmd below

```
javac -source 1.6 -target 1.6 Hello.java
```

* 2. Compile .class to .dex (Dalvik byte code)

```
dx --dex --output=Hello.dex Hello.class
```

    (1) tool dx is from F:\Users\xxx\AppData\Local\Android\sdk\build-tools\23.0.3\dx.bat


* 3. Decompile .dex to .smali

```
java -jar baksmali-2.1.2.jar -o baksmaliout Hello.dex
```



    (1) baksmali-2.1.2.jar can be downloaded at https://bitbucket.org/JesusFreke/smali/downloads

* 4. Then we got he result at baksmaliout/Hello.smali

