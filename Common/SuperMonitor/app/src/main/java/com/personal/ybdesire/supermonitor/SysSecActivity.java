package com.personal.ybdesire.supermonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SysSecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_sec);


        ListView lv = (ListView) findViewById(R.id.listview_sys_sec);

        String [] vuls_str = new String[]{
                //"KillingInTheNameOf", "Exploid", "RageAgainstTheCage", "Zimperlich"
                "KillingInTheNameOf", "Exploid", "RageAgainstTheCage", "Zimperlich", "Exploid2", "RageAgainstTheCage2", "Zimperlich2", "Exploid3", "RageAgainstTheCage3", "Zimperlich3", "Exploid4", "RageAgainstTheCage4", "Zimperlich4"
        };


        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,     Object>>();

        for(int i=0;i<vuls_str.length;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", vuls_str[i]);
            map.put("ItemText", "Android vulnerability");
            listItem.add(map);
        }

        SimpleAdapter adpt = new SimpleAdapter(this,listItem,
                R.layout.sys_sec_item,
                new String[] {"ItemTitle", "ItemText"},
                new int[] {R.id.ItemTitle,R.id.ItemText}
        );
        lv.setAdapter( adpt);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}
