package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.AsyncResponse;
import com.udacity.gradle.builditbigger.RestAsyncTask;
import com.udacity.gradle.builditbigger.free.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkStringIsNotEmpty() {
        new RestAsyncTask(new AsyncResponse() {
            @Override
            public void processFinish(String output) {
                Assert.assertFalse(output.isEmpty());
            }
        }).execute(mMainActivityActivityTestRule.getActivity());
    }

}