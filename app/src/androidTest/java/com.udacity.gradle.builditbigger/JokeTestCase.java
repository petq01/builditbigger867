package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Petya Marinova on 8/5/2018.
 */
public class JokeTestCase extends AndroidTestCase {
    public void testVerifyNotEmptyJoke() {

        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/");

        MyApi myApiService = builder.build();
        try {
            assertTrue(!"".equals(myApiService.getJoke().execute().getMyNerdJoke()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}