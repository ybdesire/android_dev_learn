package com.example.ybdesire.happybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        //ad1
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8100413825150401/8255761710");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //ad2
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //init texxt
        TextView intro1 = (TextView) findViewById(R.id.txt_intro2);
        TextView intro2 = (TextView) findViewById(R.id.txt_intro);
        TextView intro3 = (TextView) findViewById(R.id.txt_intro3);
        TextView intro4 = (TextView) findViewById(R.id.txt_intro4);
        intro1.setText(getString(R.string.intro1));
        intro2.setText(getString(R.string.intro2));
        intro3.setText(getString(R.string.intro3));
        intro4.setText(getString(R.string.intro4));


        Button btn=findViewById(R.id.btn_get_item);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                Intent myIntent = new Intent(MainActivity.this, AnswerActivity.class);
                MainActivity.this.startActivity(myIntent);

            }
        });

    }
}
