## Compile .java to java byte code

* 1. Compile .java to .class by cmd below

```
javac Hello.java
```

* 2. Decompile .class file to see the readable java byte code

```
javap -c -classpath . Hello
```

Readable java byte code (part of):

    public int foo(int, int);
    Code:
    0: iload_1
       1: iload_2
       2: iadd
       3: iload_1
       4: iload_2
       5: isub
       6: imul
       7: ireturn


## Compile .java to Dalvik byte code

* 1. Compile .java to .class by cmd below

```
javac Hello.java
```

* 2. Compile .class to .dex (Dalvik byte code)

```
dx --dex --output=Hello.dex Hello.class
```

    (1) tool dx is from F:\Users\xxx\AppData\Local\Android\sdk\build-tools\23.0.3\dx.bat
    (2) java version 1.6.0

* 3. Decompile .dex to readable Dalvik byte code

```
dexdump -d Hello.dex
```
Readable Dalvik byte code (part of)
    000198:                                        |[000198] Hello.foo:(II)I
    0001a8: 9000 0304                              |0000: add-int v0, v3, v4
    0001ac: 9101 0304                              |0002: sub-int v1, v3, v4
    0001b0: b210                                   |0004: mul-int/2addr v0, v1
    0001b2: 0f00                                   |0005: return v0