package getrich.tips.ybdesire.com.tipsgetrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //content to display
        String[] strs = new String[] {
                "first", "second", "third", "fourth", "fifth"
        };//定义一个String数组用来显示ListView的内容


        // display at the listview
        ListView lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));

        // click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //点击后在标题上显示点击了第几行
                setTitle("你点击了第"+arg2+"行");
                // start another acitvity with parameters
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putInt("page", arg2); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();



            }
        });


    }
}
