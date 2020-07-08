# 1. UI time delay


```
Handler handler=new Handler();
Runnable r=new Runnable() {
	public void run() {
		//what ever you do here will be done after 3 seconds delay.
		Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
		MainActivity.this.startActivity(myIntent);

	}
};
handler.postDelayed(r, 3000);

```

more details: `app/src/main/java/com/example/ybdesire/myprogressbar/MainActivity.java`



# 2. Update progress bar

```
Button btn = (Button)findViewById(R.id.button);
	btn.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View v) {
			ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
			cnt++;
			pb.setProgress(cnt);
		}
	});
```

more details: `app/src/main/java/com/example/ybdesire/myprogressbar/Main2Activity.java`




