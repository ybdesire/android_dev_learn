# how to collect all contacts info


1. permission

```
<uses-permission android:name="android.permission.READ_CONTACTS" />
```


2. code

https://stackoverflow.com/questions/12562151/android-get-all-contacts


```java
private void getContactList() {
    ContentResolver cr = getContentResolver();
    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
            null, null, null, null);

    if ((cur != null ? cur.getCount() : 0) > 0) {
        while (cur != null && cur.moveToNext()) {
            String id = cur.getString(
                    cur.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cur.getString(cur.getColumnIndex(
                    ContactsContract.Contacts.DISPLAY_NAME));

            if (cur.getInt(cur.getColumnIndex(
                    ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                Cursor pCur = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{id}, null);
                while (pCur.moveToNext()) {
                    String phoneNo = pCur.getString(pCur.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER));

                    Log.i(TAG, "Name: " + name);
                    Log.i(TAG, "Phone Number: " + phoneNo);
                }
                pCur.close();
            }
        }
    }
    if(cur!=null){
        cur.close();
    }
}
```

3. more details

```
public static final String AUTHORITY = "com.android.contacts";
public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "contacts");

```