package com.guider.guider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.model.LatLng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    Button freewalk, routes, obj,informat,exit;
    private boolean objects;
    private static final String TAG = "time: ";
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    private String strEndTime;
    private Date currentTime = Calendar.getInstance().getTime();
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        freewalk=(Button)findViewById(R.id.freewalk);
        routes=(Button)findViewById(R.id.routes);
        obj=(Button)findViewById(R.id.obj);
        informat=(Button)findViewById(R.id.informat);
        exit=(Button)findViewById(R.id.exit);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



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
    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            UserInformation uInfo = new UserInformation();
            uInfo.setEndTime(ds.child(userID).getValue(UserInformation.class).getEndTime());
            strEndTime = uInfo.getEndTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                date = format.parse(strEndTime);
                Log.d(TAG, String.valueOf(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (currentTime.after(date)) {
                finish();
            }
        }
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
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        informat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InformActivity.class);
                startActivity(intent);
            }
        });
    }

    }
