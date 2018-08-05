package com.petya.build.displayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TellNerdJokeIntentActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "jokeToPersist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_nerd_joke_intent);
        Intent intentWhichStartedActivity = getIntent();
        if(intentWhichStartedActivity.hasExtra(EXTRA_JOKE)){
        String joke = intentWhichStartedActivity.getStringExtra(EXTRA_JOKE);
        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);}
    }

}
