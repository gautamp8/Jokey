package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.brainbreaker.jokedisplaylibrary.DisplayJokeActivity;
import com.brainbreaker.jokedisplaylibrary.FetchAsyncTask;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tellJoke();
                new FetchAsyncTask(MainActivity.this).execute();
            }
        });
        setupAd();
    }

    private void setupAd() {
        AdView mAdView = (AdView)findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

//    private void tellJoke() {
//        new JokeRetrieverTask(new JokeRetrievalHandler()).execute();
//    }
//
//    private class JokeRetrievalHandler implements JokeRetrieverTask.OnJokeRetrievedListener {
//
//        @Override
//        public void onJokeRetrieved(String joke) {
//            Intent intent = new Intent(MainActivity.this, DisplayJokeActivity.class);
//            intent.putExtra(DisplayJokeActivity.JOKE_TEXT, joke);
//            startActivity(intent);
//        }
//    }
}
