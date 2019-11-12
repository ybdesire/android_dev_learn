# 摄像机拍照后的图像显示在ImageView上


1. 申请相机权限才可以使用设备相机

```
<uses-permission android:name="android.permission.CAMERA" />
```

2. 点击button，打开摄像机（自带的原始全屏效果）


```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    // button click, start camera
    Button btnStart = findViewById(R.id.btn_start);
    btnStart.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    });

}

```

3. 点击拍照，然后选择勾，刚才拍照的图像就会被显示在ImageView上

```
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        ImageView imageIV = findViewById(R.id.imageView);
        imageIV.setImageBitmap(photo);
    }
}
```






# Camera相关权限说明


1. Storage Permission - 如果你的应用需要保持照片或者视频到设备存储中，你必须在Manifest指定文件的写权限

```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

2. Audio Recording Permission - 你必须申请录音权限才能使用相机来录像.

```
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```

3. Location Permission - 当然如果你需要拍摄的照片记录地理位置，你同样需要申请如下权限：

```
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```


