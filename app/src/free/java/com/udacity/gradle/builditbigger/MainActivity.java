package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.brainbreaker.jokedisplaylibrary.DisplayJokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements FetchAsyncTask.TaskListener{

    ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.joke_button);
        spinner = (ProgressBar) findViewById(com.brainbreaker.jokedisplaylibrary.R.id.pbSpinner);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchAsyncTask fetchAsyncTask = new FetchAsyncTask(MainActivity.this);
                fetchAsyncTask.setListener(MainActivity.this);
                fetchAsyncTask.execute();
                spinner.setVisibility(View.VISIBLE);
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
        if (mAdView!=null) {
            mAdView.loadAd(adRequest);
        }
    }

    @Override
    public void onComplete(String jokeString, Exception e) {
        // Launch intent to joke display activity.
        if (spinner!=null){
            spinner.setVisibility(View.INVISIBLE);
        }
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        // Indicate data to display.
        intent.setAction(Intent.ACTION_VIEW);
        intent.putExtra(DisplayJokeActivity.JOKE_TEXT, jokeString);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
