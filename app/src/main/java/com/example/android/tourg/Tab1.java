package com.example.android.tourg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fiona on 10/29/17.
 */



public class Tab1 extends Fragment {
    private static final String TAG = "Tab1Fragment";




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container,false);


        return view;
    }
}