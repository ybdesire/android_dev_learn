package com.personal.ybdesire.supermonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SysSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_sec);

        String [] strs = new String[]{"123","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345","234","345"};

        ListView lv = (ListView) findViewById(R.id.listview_sys_sec);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, strs));
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}
