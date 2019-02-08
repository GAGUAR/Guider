package com.guider.guider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ObjectChoose extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames1 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls1 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_choose);
        Log.d(TAG, "onCreate: started.");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("finish_activity")) {
                    finish();
                    // DO WHATEVER YOU WANT.
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("finish_activity"));
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls1.add(R.drawable.ic_sightseeing);
        mNames1.add("APSKATES OBJEKTI");

        mImageUrls1.add(R.drawable.ic_monument);
        mNames1.add("PIEMINEKĻI");

        mImageUrls1.add(R.drawable.bed);
        mNames1.add("VIESNĪCAS");

        mImageUrls1.add(R.drawable.ic_food);
        mNames1.add("RESTORĀNI UN KAFEJNĪCAS");

        mImageUrls1.add(R.drawable.ic_iestade);
        mNames1.add("IESTĀDES");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view1);
        RecyclerAdapter1 adapter = new RecyclerAdapter1(this, mNames1, mImageUrls1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
