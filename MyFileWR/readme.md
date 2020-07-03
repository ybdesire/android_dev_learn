# Read Write file

1. add permission to manifest


```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_INTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_INTERNAL_STORAGE" />
```


2. write/read function


```
private void writeToFile(String data, Context context) {
	try {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
		outputStreamWriter.write(data);
		outputStreamWriter.close();
	}
	catch (IOException e) {
		Log.e("MyException", "File write failed: " + e.toString());
	}
}
private String readFromFile(Context context) {
	String ret = "";
	try {
		InputStream inputStream = context.openFileInput("config.txt");

		if ( inputStream != null ) {
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String receiveString = "";
			StringBuilder stringBuilder = new StringBuilder();

			while ( (receiveString = bufferedReader.readLine()) != null ) {
				stringBuilder.append("\n").append(receiveString);
			}

			inputStream.close();
			ret = stringBuilder.toString();
		}
	}
	catch (FileNotFoundException e) {
		Log.e("MyException", "File not found: " + e.toString());
	} catch (IOException e) {
		Log.e("MyException", "Can not read file: " + e.toString());
	}
	return ret;
}
```



3. more details

`app/src/main/java/com/example/ybdesire/myfilewr/MainActivity.java`


4. ref

* https://stackoverflow.com/questions/14376807/read-write-string-from-to-a-file-in-android




