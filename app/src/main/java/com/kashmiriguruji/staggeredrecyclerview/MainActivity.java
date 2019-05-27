package com.kashmiriguruji.staggeredrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final int NUM_COLUMNS  = 2;

    private ArrayList<String>mImageUrls=new ArrayList<>();
    private ArrayList<String> mNames=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmap();
    }

    private  void initImageBitmap()
    {
        Log.d(TAG, "initImageBitmap: preparing bitmaps");

        mImageUrls.add("https://www.pexels.com/photo/scenic-view-of-beach-248797/");
        mNames.add("scenic-view-of-beach");

        mImageUrls.add("https://www.pexels.com/photo/daylight-environment-forest-idyllic-459225/");
        mNames.add("daylight-environment-forest-idyllic");

        mImageUrls.add("https://www.pexels.com/photo/close-up-of-leaf-326055/");
        mNames.add("close-up-of-leaf");

        mImageUrls.add("https://www.pexels.com/photo/gray-bridge-and-trees-814499/");
        mNames.add("gray-bridge-and-trees");

        mImageUrls.add("https://www.pexels.com/photo/lavender-field-under-gray-and-blue-skies-at-night-1558732/");
        mNames.add("lavender-field-under-gray-and-blue-skies-at-night");

        mImageUrls.add("https://www.pexels.com/photo/nature-red-forest-leaves-33109/");
        mNames.add("nature-red-forest-leaves");

        mImageUrls.add("https://www.pexels.com/photo/scenic-view-of-mountain-1666021/");
        mNames.add("scenic-view-of-mountain-1666021");

        mImageUrls.add("https://www.pexels.com/photo/tree-with-brunch-and-green-leaves-during-sunset-70365/");
        mNames.add("tree-with-brunch-and-green-leaves-during-sunset");

        mImageUrls.add("https://www.pexels.com/photo/clouds-daylight-forest-grass-371589/");
        mNames.add("clouds-daylight-forest-grass");

        mImageUrls.add("https://www.pexels.com/photo/clouds-cloudy-countryside-farm-236047/");
        mNames.add("clouds-cloudy-countryside-farm");
        initRecyclerview();
    }

    private   void initRecyclerview()
    {
        Log.d(TAG, "initRecyclerview: initializing Recyclerview");

        RecyclerView recyclerView=findViewById(R.id.rec);
        StraggeredRecyclerviewAdapter straggeredRecyclerviewAdapter=
                new StraggeredRecyclerviewAdapter(this,mNames,mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager=
                new StaggeredGridLayoutManager(NUM_COLUMNS,LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(straggeredRecyclerviewAdapter);

    }
}
