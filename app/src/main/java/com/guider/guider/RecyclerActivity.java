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

public class RecyclerActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycl);
        Log.d(TAG, "onCreate: started.");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("finish_activity")) {
                    finish();
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("finish_activity"));
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        Intent myIntent = getIntent(); // gets the previously created intent
        String chosenstring = myIntent.getStringExtra("chosen"); // will return "activity integer from GPS_Service"
        int chosenNo = Integer.parseInt(chosenstring);
        if(chosenNo==1){
        mImageUrls.add(R.drawable.am);
        mNames.add("AMATU MĀJA");

        mImageUrls.add(R.drawable.lop);
        mNames.add("LIVONIJAS ORDEŅA PILS");

        mImageUrls.add(R.drawable.rl);
        mNames.add("RĀTSLAUKUMS");

        mImageUrls.add(R.drawable.tulkmaja);
        mNames.add("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA");

        mImageUrls.add(R.drawable.strkv);
        mNames.add("STRŪKLAKA 'KUĢU VĒROTĀJS'");

        mImageUrls.add(R.drawable.svnik);
        mNames.add("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA");

        mImageUrls.add(R.drawable.vt);
        mNames.add("VENTSPILS TIRGUS");
        }
        if(chosenNo==2){
            mImageUrls.add(R.drawable.gb);
            mNames.add("VENTSPILS GALVENĀ BIBLIOTĒKA");

            mImageUrls.add(R.drawable.bt);
            mNames.add("VENTSPILS BRĪVOSTAS PĀRVALDE");

            mImageUrls.add(R.drawable.pt);
            mNames.add("PRĀMJU TERMINĀLIS");

            mImageUrls.add(R.drawable.dc);
            mNames.add("VENTSPILS DIGITĀLAIS CENTRS");

            mImageUrls.add(R.drawable.jn);
            mNames.add("VENTSPILS JAUNRADES NAMS");
        }
        if(chosenNo==3){
            mImageUrls.add(R.drawable.jav);
            mNames.add("JŪRAKMENS");

            mImageUrls.add(R.drawable.kvp);
            mNames.add("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM");

            mImageUrls.add(R.drawable.kk);
            mNames.add("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM");

            mImageUrls.add(R.drawable.jf);
            mNames.add("PIEMINEKLIS JĀNIM FABRICIUSAM");

        }
        if(chosenNo==4){
            mImageUrls.add(R.drawable.landora);
            mNames.add("LANDORA 6");

            mImageUrls.add(R.drawable.erm);
            mNames.add("ĒRMANĪTIS");

            mImageUrls.add(R.drawable.skroderkrogs);
            mNames.add("SKRODERKROGS");

            mImageUrls.add(R.drawable.dolcevita);
            mNames.add("DOLCE VITA");

            mImageUrls.add(R.drawable.burgerbars);
            mNames.add("BURGERBĀRS");

            mImageUrls.add(R.drawable.ostas23);
            mNames.add("OSTAS 23");

        }
        if(chosenNo==5){
            mImageUrls.add(R.drawable.kupfer);
            mNames.add("KUPFERNAMS");

            mImageUrls.add(R.drawable.klosteris);
            mNames.add("KLOSTERIS");

            mImageUrls.add(R.drawable.mazais);
            mNames.add("MAZAIS NAMIŅŠ");

            mImageUrls.add(R.drawable.oranznams);
            mNames.add("ORANŽAIS NAMS");

            mImageUrls.add(R.drawable.portoss);
            mNames.add("PORTOSS");

            mImageUrls.add(R.drawable.dzintari);
            mNames.add("DZINTARI");
        }

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerAdapter adapter = new RecyclerAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
