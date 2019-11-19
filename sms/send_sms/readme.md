# how to send sms


## 1. permission


```
<uses-permission android:name="android.permission.SEND_SMS" />

```


## 2. 3 ways to send

1. 

```
SmsManager smsManager = SmsManager.getDefault();
smsManager.sendTextMessage("phoneNo", null, "sms message", null, null);
```


2. 下面这种方法，目前的Android版本里，无法做到直接发送（phone number和sms body无效了）。它会弹出系统的发短信对话框。

```
Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
smsIntent.setType("vnd.android-dir/mms-sms");
smsIntent.putExtra("address","your desired phoneNumber");         
smsIntent.putExtra("sms_body","your desired message");
startActivity(smsIntent);
```


3. 下面这种方法，目前的Android版本里，无法做到直接发送（phone number和sms body无效了）。它会弹出系统的发短信对话框。

```
Uri uriSms = Uri.parse("smsto:1234567899");   
Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uriSms);   
intentSMS.putExtra("sms_body", "The SMS text");   
startActivity(intentSMS); 
```





