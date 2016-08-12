# Extract all class names for APK by Androguard



```
# androlyze.py  -s
In [1]: a = APK("./1.apk")
In [6]: d = DalvikVMFormat(a.get_dex())
In [7]: dx = VMAnalysis(d)
In [21]: class_list = d.get_classes()
In [47]: for i in range(4750,4757):
    ...:     class_item = class_list[i]
    ...:     class_name = class_item.get_name()
    ...:     print(class_name)
    ...:
Lcom/google/android/gms/internal/ib$3;
Lcom/google/android/gms/internal/ib$4;
Lcom/google/android/gms/internal/ib$5;
Lcom/google/android/gms/internal/jf$1;
Lcom/google/android/gms/internal/jf$2;
Lcom/google/android/gms/internal/jf$3;
Lcom/google/android/gms/internal/jf$4;

```


