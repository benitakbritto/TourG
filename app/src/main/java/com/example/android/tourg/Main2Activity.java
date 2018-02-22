package com.example.android.tourg;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    // private boolean isShowingBackLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1());
        adapter.addFragment(new Tab2());
        viewPager.setAdapter(adapter);
    }


}

