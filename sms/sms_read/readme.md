# how to read sms



## 1. permission

```
<uses-permission android:name="android.permission.READ_SMS" />
```

## 2. read all sms


```java
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Toast;


public void getAllSms(Context context) {
    ContentResolver cr = context.getContentResolver();
    Cursor c = cr.query(Telephony.Sms.CONTENT_URI, null, null, null, null);
    int totalSMS = 0;
    if (c != null) {
        totalSMS = c.getCount();
        if (c.moveToFirst()) {
            for (int j = 0; j < totalSMS; j++) {
                String smsDate = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.DATE));
                String number = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.ADDRESS));
                String body = c.getString(c.getColumnIndexOrThrow(Telephony.Sms.BODY));
                String type="";
                switch (Integer.parseInt(c.getString(c.getColumnIndexOrThrow(Telephony.Sms.TYPE)))) {
                    case Telephony.Sms.MESSAGE_TYPE_INBOX:
                        type = "inbox";
                        break;
                    case Telephony.Sms.MESSAGE_TYPE_SENT:
                        type = "sent";
                        break;
                    case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                        type = "outbox";
                        break;
                    default:
                        break;
                }
                Toast.makeText(this, ""+type+" "+number+" "+body, Toast.LENGTH_SHORT).show();
                c.moveToNext();
            }
        }

        c.close();

    } else {
        Toast.makeText(this, "No message to show!", Toast.LENGTH_SHORT).show();
    }
}
```

## 3. more detail

```
public static final Uri CONTENT_URI = Uri.parse("content://sms");
```

## 4. ref

* https://stackoverflow.com/questions/848728/how-can-i-read-sms-messages-from-the-device-programmatically-in-android
