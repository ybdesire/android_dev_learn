# Extract package names for APK by Androguard



```
# androlyze.py  -s
In [1]: a = APK("./1.apk")
In [6]: d = DalvikVMFormat(a.get_dex())
In [7]: dx = VMAnalysis(d)
In [17]: pkg = dx.get_tainted_packages()
In [20]: for i in pkg.get_packages():
    ...:     print(i)
    ...:
    ...:
(<androguard.core.analysis.analysis.TaintedPackage object at 0x1efbbd10>, 'Ljava/io/FileNotFoundException;')
(<androguard.core.analysis.analysis.TaintedPackage object at 0x25080990>, 'Lorg/cocos2dx/lib/Cocos2dxEditText;')
(<androguard.core.analysis.analysis.TaintedPackage object at 0x1dcf4490>, 'Landroid/content/SharedPreferences;')

```


