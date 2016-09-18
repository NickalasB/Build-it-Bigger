package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String LOG_TAG = MainActivityFragment.class.getSimpleName();


//    InterstitialAd mInterstitialAd;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        mInterstitialAd = new InterstitialAd(getContext());
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                requestNewInterstitial();
//            }
//        });
//        requestNewInterstitial();


        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

//        if (mInterstitialAd.isLoaded()){
//            mInterstitialAd.show();
//        }

        return root;

    }

//    private void requestNewInterstitial(){
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice("34D91EE282E9619F629594693CC97B9E")
//                .build();
//
//        mInterstitialAd.loadAd(adRequest);
//    }

}