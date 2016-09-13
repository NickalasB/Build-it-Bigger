package com.zonkey.myandroidjokelibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names cc match



    public JokeFragment() {
        // Required empty public constructor
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_joke, container,
                false);
        TextView jokeTextView = (TextView)rootView.findViewById(R.id.joke_fragment_textview);
        // Inflate the layout for this fragment
        jokeTextView.setText("You're almost there you beautiful bastard!");

        return inflater.inflate(R.layout.fragment_joke, container, false);
    }


}
