package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.brainbreaker.jokedisplaylibrary.DisplayJokeActivity;


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
