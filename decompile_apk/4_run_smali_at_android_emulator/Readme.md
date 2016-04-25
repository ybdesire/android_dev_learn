## Write smail and run it at Android Emulator


### 1. Write smail file
* Write "hello world" logic at file `HelloWolrd.smali`.

### 2. Compile smali file to dex, and zip dex file to 'HelloWorld.zip'

```
java -jar smali-2.1.2.jar -o classes.dex HelloWorld.smali
```

    (1) smali-2.1.2.jar can be downloaded at https://bitbucket.org/JesusFreke/smali/downloads

### 3. Open Android Emulator

### 4. Push 'HelloWorld.zip' to Android Emulator

```
adb push HelloWorld.zip /data/local/
```

### 5. Run HelloWorld.zip by Dalvik VM

```
adb shell dalvikvm -cp /data/local/HelloWorld.zip HelloWorld
```



