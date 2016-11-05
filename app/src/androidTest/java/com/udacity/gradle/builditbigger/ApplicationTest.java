package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase{
    private final CountDownLatch mSignal = new CountDownLatch(1);

    public void testJokeRetriever() {
        FetchAsyncTask fetchAsyncTask = new FetchAsyncTask(getContext());
        fetchAsyncTask.setListener(new FetchAsyncTask.TaskListener() {
            @Override
            public void onComplete(String jokeString, Exception e) {
                assertTrue(jokeString != null && jokeString.length() > 0);
                mSignal.countDown();
            }
        });
        fetchAsyncTask.execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
            if (!success) {
                fail("Test timed out, make sure the server is actually running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }
}