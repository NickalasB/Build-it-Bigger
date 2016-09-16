package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.nickbradshaw.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by nickbradshaw on 9/14/16.
 */
public class GetJokeAsyncTask extends AsyncTask<String, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    public GetJokeAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-143311.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        String joke = null;
        try {
            joke = myApiService.getJokes().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
        return joke;
    }

}
