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


2. 

```
Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
smsIntent.setType("vnd.android-dir/mms-sms");
smsIntent.putExtra("address","your desired phoneNumber");         
smsIntent.putExtra("sms_body","your desired message");
startActivity(smsIntent);
```


3. 

```
Uri uriSms = Uri.parse("smsto:1234567899");   
Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uriSms);   
intentSMS.putExtra("sms_body", "The SMS text");   
startActivity(intentSMS); 
```





