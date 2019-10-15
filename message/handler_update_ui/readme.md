# description

Handler的用法：

* 在main thread中，监听消息，并将收到的消息更新UI的TextView
* 启动另一个thread发送消息


# how

1. 在主线程中（定义处理消息的方法）

```
mHandler = new Handler(){
    public void handleMessage(Message msg){//此方法在ui线程运行
        switch(msg.what) {
            case MSG_HELLO:
                //display content
                TextView xxx = (TextView)findViewById(R.id.show);
                xxx.setText(""+msg.obj);

        }
    }
};


mThread = new Thread(runnable);
mThread.start();//线程启动
```

将具体发送消息的逻辑写到另一个线程mThread中。


2. 在另一个线程中（发送消息）

```
Runnable runnable = new Runnable() {
    @Override
    public void run() {//run()在新的线程中运行
        while(true) {
            mHandler.obtainMessage(MSG_HELLO, "hello+" + count).sendToTarget();
            try {
                Thread.sleep(1000);
                count += 1;
            } catch (InterruptedException e) {
                // Process exception
            }
        }
    }
};
```

每隔一秒发送一个消息



# ref

* https://www.jianshu.com/p/e5b89601562a