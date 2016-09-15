package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.javaJokes;
import com.zonkey.myandroidjokelibrary.MainJokeActivity;

public class MainActivity extends ActionBarActivity {

    private javaJokes mjavaJokes = new javaJokes();
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);
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

        getAndShowJoke();

//        Intent mIntent = new Intent(this, MainJokeActivity.class);
//        mIntent.putExtra("joke1", mjavaJokes.getJavaJoke1());
//        startActivity(mIntent);
//        Toast.makeText(this, mjavaJokes.getJavaJoke1(), Toast.LENGTH_SHORT).show();
    }


    private void getAndShowJoke() {
        mProgressBar.setVisibility(View.VISIBLE);

        new GetJokeAsyncTask() {
            //            new GetJokeAsyncTask().execute(new Pair<Context, String>(this, "Nick Bradshaw"));
            @Override
            protected void onPostExecute(String jokeString) {
                if (jokeString != null) {
                    Intent mIntent = new Intent(getApplicationContext(),MainJokeActivity.class);
                    mIntent.putExtra("joke1", mjavaJokes.getJavaJoke1());
                    startActivity(mIntent);

                } else {
                    Toast.makeText(MainActivity.this, R.string.joke_error_toast, Toast.LENGTH_LONG).show();
                }

                    mProgressBar.setVisibility(View.GONE);
            }
        }.execute();
    }

}


