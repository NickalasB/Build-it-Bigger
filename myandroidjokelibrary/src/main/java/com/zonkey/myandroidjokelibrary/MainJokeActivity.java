package com.zonkey.myandroidjokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {

    private String Item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        TextView jokeTextView = (TextView)findViewById(R.id.joke_fragment_textview);
        jokeTextView.setText(getIntent().getExtras().getString("joke1"));

    }
}
