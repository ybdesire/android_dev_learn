# create basic video player



1. add below item to layout

```
<VideoView
android:id="@+id/vdVw"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:layout_gravity="center" />
```

details: `app/src/main/res/layout/activity_main.xml`


2. add mp4 file to `app/src/main/res/raw/videoplayback.mp4`


3. load the video at Activity


```
package com.example.ybdesire.myvideoplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView =(VideoView)findViewById(R.id.vdVw);
        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Location of Media File
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback);
        //Starting VideView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}

```

details: `app/src/main/java/com/example/ybdesire/myvideoplayer/MainActivity.java`



