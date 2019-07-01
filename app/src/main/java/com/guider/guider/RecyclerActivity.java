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

public class RecyclerActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<Integer>();
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

        mImageUrls.add(R.drawable.niklutbaz);
        mNames.add("VENTSPILS NIKOLAJA LUTERĀŅU BAZNĪCA");
            mImageUrls.add(R.drawable.lutdrnams);
            mNames.add("VENTSPILS LUTERĀŅU DRAUDZES NAMS");
            mImageUrls.add(R.drawable.aka);
            mNames.add("AKA VENTSPILS TIRGUS LAUKUMĀ");
            mImageUrls.add(R.drawable.zvantornis);
            mNames.add("ZVANU TORNIS TIRGUS LAUKUMĀ");
            mImageUrls.add(R.drawable.piespog);
            mNames.add("GOVIS “PIE SPOGUĻA”");
            mImageUrls.add(R.drawable.marites);
            mNames.add("MĀRĪTES");
            mImageUrls.add(R.drawable.sievgovs);
            mNames.add("SIEVIŠĶĪGĀ GOVS");
            mImageUrls.add(R.drawable.supgovs);
            mNames.add("GOTIŅA ŠŪPOLĒS");
            mImageUrls.add(R.drawable.latvmeln);
            mNames.add("LATVIJAS MELNĀ");
            mImageUrls.add(R.drawable.hute);
        mNames.add("LEMBERGA HŪTE");

        mImageUrls.add(R.drawable.staldz);
        mNames.add("JŪRAS STĀVKRASTI STALDZENĒ");

        mImageUrls.add(R.drawable.puka);
        mNames.add("PUĶU GOVS");

        mImageUrls.add(R.drawable.gaismas);
        mNames.add("GAISMAS GOVS");

        mImageUrls.add(R.drawable.matrozis);
        mNames.add("GOVS MATROZIS");

        mImageUrls.add(R.drawable.piena);
        mNames.add("PIENA CEĻŠ GOVS");

        mImageUrls.add(R.drawable.zala);
        mNames.add("VENTSPILS ZĀĻU GOVS");

        mImageUrls.add(R.drawable.celot);
        mNames.add("GOVS CEĻOTĀJA");

        mImageUrls.add(R.drawable.mazb);
        mNames.add("VENTSPILS MAZBĀNĪTIS");

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
            
            mImageUrls.add(R.drawable.parvbibl);
            mNames.add("PĀRVENTAS BIBLIOTĒKA");

            mImageUrls.add(R.drawable.vsk);
            mNames.add("VENTSPILS 2. VIDUSSKOLA");
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
            
            mImageUrls.add(R.drawable.pbm);
            mNames.add("PIEJŪRAS BRĪVDABAS MUZEJS");

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

            mImageUrls.add(R.drawable.rgalds);
            mNames.add("RĀTSGALDS");

            mImageUrls.add(R.drawable.courlander);
            mNames.add("VENTSPILS ALUS DARĪTAVA “COURLANDER”");

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
