package com.guider.guider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ObjectChoose extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean objects;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    private String strEndTime;
    private Date currentTime = Calendar.getInstance().getTime();
    private Date date;

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
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo ==null){
            startActivity(new Intent(getApplicationContext(),NoInternet.class));
            finish();
        }
        registerReceiver(broadcastReceiver, new IntentFilter("finish_activity"));
        initImageBitmaps();
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
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        Intent intent2= getIntent();
        objects= (boolean) intent2.getExtras().get("ObjBool");
        if(objects==true) {
           mImageUrls1.add(R.drawable.ic_sightseeing);
            mNames1.add(getString(R.string.aps));

            mImageUrls1.add(R.drawable.ic_monument);
            mNames1.add(getString(R.string.piem));

            mImageUrls1.add(R.drawable.bed);
            mNames1.add(getString(R.string.hotels));

            mImageUrls1.add(R.drawable.ic_food);
            mNames1.add(getString(R.string.cafe));

            mImageUrls1.add(R.drawable.ic_iestade);
            mNames1.add(getString(R.string.iestad));
        }else {
            mImageUrls1.add(R.drawable.route_choose);
            mNames1.add(getString(R.string.VECPILSĒTA));
        }

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
