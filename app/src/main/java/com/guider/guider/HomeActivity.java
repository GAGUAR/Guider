package com.guider.guider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.maps.model.LatLng;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button freewalk, routes, obj, lang,informat,exit;
    private boolean objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        freewalk=(Button)findViewById(R.id.freewalk);
        routes=(Button)findViewById(R.id.routes);
        obj=(Button)findViewById(R.id.obj);
        lang=(Button)findViewById(R.id.lang);
        informat=(Button)findViewById(R.id.informat);
        exit=(Button)findViewById(R.id.exit);
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
        buttons();
    }

    private void buttons() {
        freewalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String latLngEnd=null;
                ArrayList<LatLng>waypts=null;
                intent.putExtra("waypts",waypts);
                intent.putExtra("latLngEnd",latLngEnd);
                startActivity(intent);
                finish();
            }
        });
        routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ObjectChoose.class);
                objects=false;
                intent.putExtra("ObjBool",objects);
                startActivity(intent);
            }
        });
        obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ObjectChoose.class);
                objects=true;
                intent.putExtra("ObjBool",objects);
                startActivity(intent);
            }
        });
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        informat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}