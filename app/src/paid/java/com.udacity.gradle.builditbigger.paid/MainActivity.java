package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.petya.build.displayactivity.TellNerdJokeIntentActivity;
import com.udacity.gradle.builditbigger.AsyncResponse;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.RestAsyncTask;

import java.util.concurrent.ExecutionException;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        new RestAsyncTask(MainActivity.this).execute(this);

    }
    @Override
    public void processFinish(String output) {
        joke=output;
        Intent intent = new Intent(this, TellNerdJokeIntentActivity.class);
        intent.putExtra(TellNerdJokeIntentActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }


}