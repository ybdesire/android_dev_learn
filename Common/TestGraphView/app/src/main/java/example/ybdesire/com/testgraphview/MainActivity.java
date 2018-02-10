package example.ybdesire.com.testgraphview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private int mInterval = 1000; // 1 seconds by default, can be changed later
    private Handler mHandler;
    private static int count=0;

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                GraphView graph2 = (GraphView) findViewById(R.id.graph2);
                // set manual Y bounds
                graph2.getViewport().setYAxisBoundsManual(true);
                graph2.getViewport().setMinY(0);
                graph2.getViewport().setMaxY(100);

                graph2.removeAllSeries();
                DataPoint[] dps = new DataPoint[] {
                        new DataPoint(0, 1+count),
                        new DataPoint(1, 5+count),
                        new DataPoint(2, 3+count),
                        new DataPoint(3, 2+count),
                        new DataPoint(4, 6+count)
                };
                LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(dps);
                graph2.addSeries(series2);
                count++;
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, mInterval);//将指定Runnable（包装成PostMessage）加入到MessageQueue中，然后Looper不断从MessageQueue中读取Message进行处理
            }
        }
    };
    void startRepeatingTask() {
        mStatusChecker.run();
    }
    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph1.addSeries(series1);

        //
        mHandler = new Handler();
        startRepeatingTask();


    }
}
