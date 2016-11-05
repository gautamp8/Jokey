package com.brainbreaker.jokedisplaylibrary;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class DisplayJokeActivity extends AppCompatActivity {

    private TextView jokeTextHolder;
    public static final String JOKE_TEXT = "JOKE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        jokeTextHolder = (TextView)findViewById(R.id.sample_text);

        Bundle extras = getIntent().getExtras();
        Log.e("Extras String", extras.getString(JOKE_TEXT));
        if (extras != null) {
            jokeTextHolder.setText(extras.getString(JOKE_TEXT));
        }
    }
}
