# Intro

* Service 是一个可以在后台执行长时间运行操作而不使用用户界面的应用组件。服务可由其他应用组件启动，而且即使用户切换到其他应用，服务仍将在后台继续运行。
* Service其实是运行在主线程里的，如果直接在Service中处理一些耗时的逻辑，就会导致程序ANR

# Service的基本用法


* 在Android Studio的项目中，右键，New，Service，就创建了一个Service。一个service有以下方法
   * onCreate()
   * onStartCommand()
   * onDestroy()

启动一个Service的时候，会调用该Service中的onCreate()和onStartCommand()方法。
启动Service之后，就可以在onCreate()或onStartCommand()方法里去执行一些具体的逻辑了。

Service是通过intent启动、销毁的。

* 启动Service

```java
Intent startIntent = new Intent(MainActivity.this, MyService.class);
startService(startIntent);
```

* 销毁Service

```java
Intent stopIntent = new Intent(MainActivity.this, MyService.class);
stopService(stopIntent);
```

# Service和Activity通信

所谓通信，就是在Activity中，指定service去执行一项特定的任务。



# Service和Thread的关系

* Service和Thread之间没有任何关系
* MainActivity和Service的线程ID是完全一样的
* 所谓Service是Android的后台就是指，它的运行是完全不依赖UI的。即使Activity被销毁，或者程序被关闭，只要进程还在，Service就可以继续运行
* Service的一般用法：在Service中再创建一个子线程，然后在这里去处理耗时逻辑
* 为什么不直接在Activity里创建Thread呢？
   * 这是因为Activity很难对Thread进行控制，当Activity被销毁之后，就没有任何其它的办法可以再重新获取到之前创建的子线程的实例。而且在一个Activity中创建的子线程，另一个Activity无法对其进行操作。

# Ref

* (1)  Android Service完全解析，关于服务你所需知道的一切, http://blog.csdn.net/guolin_blog/article/details/11952435

