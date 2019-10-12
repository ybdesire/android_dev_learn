# description

Handler的用法：

* 在main thread中，点击button，会给另一个thread发送消息。


# how

1. 在主线程中（发送消息）

```
mHandler.obtainMessage(MSG_HELLO, str).sendToTarget();//发送消息到另一个Thread
```

str是发送的具体消息


2. 在另一个线程中（接受消息）


```
public void run() {
            //建立消息循环的步骤
            Looper.prepare();//1、初始化Looper
            mHandler = new Handler(){//2、绑定handler到CustomThread实例的Looper对象
                public void handleMessage (Message msg) {//3、定义处理消息的方法
                    switch(msg.what) {
                        case MSG_HELLO:
                            Log.d("Test", "CustomThread receive msg:" + (String) msg.obj);
                    }
                }
            };
            Looper.loop();//4、启动消息循环
        }
```

理解这里的关键

* 和主线程使用同一个mHandler变量
* 启动消息循环后，handler就会让这个线程进入无限循环，不断从msg queue中读取消息并进行处理


# ref

* https://www.jianshu.com/p/e5b89601562a