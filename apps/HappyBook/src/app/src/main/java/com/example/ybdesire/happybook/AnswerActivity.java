package com.example.ybdesire.happybook;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdView;

public class AnswerActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        // ad1
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8100413825150401/8255761710");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //ad2
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        List<String> contents = new ArrayList<>();
        contents.add(getString(R.string.item1));
        contents.add(getString(R.string.item2));
        contents.add(getString(R.string.item3));
        contents.add(getString(R.string.item4));
        contents.add(getString(R.string.item5));
        contents.add(getString(R.string.item6));
        contents.add(getString(R.string.item7));
        contents.add(getString(R.string.item8));
        contents.add(getString(R.string.item9));
        contents.add(getString(R.string.item10));
        contents.add(getString(R.string.item11));

        Random r = new Random();
        int rand_int = r.nextInt((11 - 1) + 1) + 1;

        TextView textView = (TextView) findViewById(R.id.textViewAnswer);
        if(rand_int>=1 && rand_int<=11) {
            textView.setText(contents.get(rand_int));
        }
        else
        {
            textView.setText(R.string.item6);
        }

        Button btn=findViewById(R.id.button_back);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                finish();

            }
        });

    }

}
