package example.ybdesire.com.regexdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pattern PATTERN_NUMBERS = Pattern.compile(
                "\\b(\\d*[.]?\\d+)\\b");
        String ss="hello 123 xxx 256";//2 number in string
        Matcher matcher = PATTERN_NUMBERS.matcher(ss);
        int count=0;
        while (matcher.find()) {
            TextView txtv = findViewById(R.id.txt);
            count++;
            txtv.setText("there is number in string " + count);
        }

    }
}
