package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.example.nickbradshaw.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by nickbradshaw on 9/14/16.
 */
public class GetJokeAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-143311.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

//        context = params[0].first;
//        String name = params[0].second;
//        String joke = params[0].second;

        String joke = null;
        try {
//            return myApiService.sayHi(name).execute().getData();
//            return myApiService.getJokes().execute().getData();
            joke = myApiService.getJokes().execute().getData();


        } catch (IOException e) {
            return e.getMessage();
        }
        return joke;
    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//    }
}
