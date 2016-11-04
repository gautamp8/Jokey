package com.brainbreaker.jokedisplaylibrary;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private FloatingActionButton button;
    private TextView jokeTextHolder;
    private ProgressBar spinner;
    public static final String JOKE_TEXT = "JOKE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        jokeTextHolder = (TextView)findViewById(R.id.sample_text);
        button = (FloatingActionButton)findViewById(R.id.get_joke_fab);
        spinner = (ProgressBar) findViewById(R.id.pbSpinner);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            jokeTextHolder.setText(extras.getString(JOKE_TEXT));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                // 1. Retrieve joke from backend using async task.
                new FetchAsyncTask(DisplayJokeActivity.this).execute();
                // 2. Clear existing joke, display load indicator while waiting.
                jokeTextHolder.setVisibility(View.GONE);
                spinner.setVisibility(View.VISIBLE);
                // 3. If on free version -> immediately display add (min 5) then click forward to joke
                // 4. Animate the shit out of it.
                Snackbar.make(jokeTextHolder, "Retrieving Joke...", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Okay", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                spinner.setVisibility(View.INVISIBLE);
                                button.setVisibility(View.VISIBLE);
                                jokeTextHolder.setVisibility(View.VISIBLE);
                            }
                        }).show();
            }
        });
    }
}
