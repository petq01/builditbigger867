package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.petya.build.displayactivity.TellNerdJokeIntentActivity;
import com.udacity.gradle.builditbigger.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.RestAsyncTask;

import java.util.concurrent.ExecutionException;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    String joke;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.inter_ad));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                super.onAdClosed();
                showJokeviaIntent();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                showJokeviaIntent();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                try {
                    joke = new RestAsyncTask().execute(MainActivity.this).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    joke = null;
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    joke = null;
                }
            }


        });

    }

    private void showJokeviaIntent() {
        Intent intent = new Intent(MainActivity.this, TellNerdJokeIntentActivity.class);
        intent.putExtra(TellNerdJokeIntentActivity.EXTRA_JOKE, joke);
        startActivity(intent);
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
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


}