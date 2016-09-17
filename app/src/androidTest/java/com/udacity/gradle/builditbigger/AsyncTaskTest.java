package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * Created by nickbradshaw on 9/17/16.
 */
public class AsyncTaskTest extends AndroidTestCase {
    //I had a very hard time understanding how to make this work so I used a solution
    //from another student that I was able to wrap my head around
    //solution by @Matt_from_Pestulon
    // https://discussions.udacity.com/t/async-task-test-where-to-even-begin/159593/4

    GetJokeAsyncTask task;
    String result;
    @Mock
    Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new GetJokeAsyncTask(mockContext) {
            @Override
            protected void onPostExecute(String joke) {
                //Override this method since we don't need to actually launch intent
                super.onPostExecute(joke);
            }
        };
    }

    public void testAsyncTaskReturnType() {
        try {
            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task.execute();
            result = task.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        } catch (Exception e) {
            fail("Timed out");
        }
    }


}
