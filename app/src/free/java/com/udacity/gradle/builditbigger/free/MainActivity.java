package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.javaJokes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.GetJokeAsyncTask;
import com.udacity.gradle.builditbigger.R;
import com.zonkey.myandroidjokelibrary.MainJokeActivity;

public class MainActivity extends ActionBarActivity {

    InterstitialAd mInterstitialAd;

    private javaJokes mjavaJokes = new javaJokes();
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        //adMob full-screen ad code
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                getAndShowJoke();

            }
        });
        requestNewInterstitial();
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

    public void tellJoke(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            getAndShowJoke();
        }
    }


    private void getAndShowJoke() {
//        Toast.makeText(getApplicationContext(), mjavaJokes.getJavaJoke1(), Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.VISIBLE);
        new GetJokeAsyncTask(this) {
            //            new GetJokeAsyncTask().execute(new Pair<Context, String>(this, "Nick Bradshaw"));
            @Override
            protected void onPostExecute(String jokeString) {
                if (jokeString != null) {
                    Intent mIntent = new Intent(getApplicationContext(), MainJokeActivity.class);
                    mIntent.putExtra("joke1", mjavaJokes.getJavaJoke1());
                    startActivity(mIntent);
                } else {
                    Toast.makeText(MainActivity.this, R.string.joke_error_toast, Toast.LENGTH_LONG).show();
                }

                mProgressBar.setVisibility(View.GONE);

            }
        }.execute();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("34D91EE282E9619F629594693CC97B9E")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}


