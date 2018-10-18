package getrich.tips.ybdesire.com.tipsgetrich;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Main2Activity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // init and load banner ad
        MobileAds.initialize(this, "ca-app-pub-8100413825150401~9396888732");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8100413825150401/1718543413");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        // get page num from main activity
        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b != null)
            value = b.getInt("page");
        setTitle(getString(R.string.txt_page)+value);

        //display content
        String str=getString(R.string.txt_blank);
        if(value!=-1)
        {
            String[] tab_names = getResources().getStringArray(R.array.tabs_names);
            str = tab_names[value];
        }
        TextView etxt= (TextView) findViewById(R.id.textView);
        etxt.setText("    "+str);

        // back button click
        Button button= (Button) findViewById(R.id.btn_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                finish();
            }
        });


    }

}
