package com.guider.guider;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guider.guider.directionhelpers.FetchURL;
import com.guider.guider.directionhelpers.TaskLoadedCallback;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener, TaskLoadedCallback {
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private static final String ATAG = "Opened";
    private Button stop, gpscenter, yes, no,crossexit;
    private BroadcastReceiver broadcastReceiver;
    private BroadcastReceiver broadcastReceiver2;
    private BroadcastReceiver broadcastReceiver3;
    private BroadcastReceiver broadcastReceiver4;
    private RelativeLayout exitlout;
    private RelativeLayout loadinglout;
    private RelativeLayout progbar;
    private Marker currentLocationMarker;
    private boolean moved;
    private String latlngE;
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private MarkerOptions place1, place2;
    private PolylineOptions polylineOptions;
    private Polyline currentPolyline;
    private LatLng startRoute, latlng, latlngEnd, latLng1, latLng2, latLng4, latLng5, latLng6,latLng7,latLng8,latLng9, latLng10,
            latLng11, latLng12, latLng13, latLng14, latLng15, latLng16,latLng17,latLng18,latLng19,latLng20,latLng21,latLng22,latLng23,
            latLng24,latLng25,latLng26,latLng27,latLng28,latLng29, latLng30,latLng31,latLng32,latLng33,latLng34,latLng35,latLng36,latLng37,latLng38,latLng39,latLng40,latLng41,latLng42,latLng43,latLng44,latLng45,latLng46,latLng47,latLng48,latLng49,latLng50,latLng51,latLng52;
    private boolean routeBoolean=false;
    private boolean ROUTE_PERMISSION = false;
    private ArrayList<LatLng>waypts=new ArrayList<>();
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    private String strEndTime;
    private Date currentTime = Calendar.getInstance().getTime();
    private Date date;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mLocationPermissionsGranted) {
            getDeviceLocation();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setOnCameraMoveStartedListener(this);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
            mMap.getUiSettings().setZoomGesturesEnabled(false);
            mMap.getUiSettings().setScrollGesturesEnabled(false);
            mMap.getUiSettings().setTiltGesturesEnabled(false);
            mMap.getUiSettings().setRotateGesturesEnabled(false);
            startserv();

        }
    }

    private void startserv() {
        if(latlng==null) {
            loadinglout.setVisibility(View.VISIBLE);
        }

        if(latlngE!=null) {
            String[] LatLng = latlngE.split(",");
            double latitude = Double.parseDouble(LatLng[0]); //Person coords
            double longitude = Double.parseDouble(LatLng[1]);
            latlngEnd = new LatLng(latitude, longitude);

        if(latlngEnd!=null){
            routeBoolean=true;
            Log.d(ATAG, String.valueOf(routeBoolean));
        }
        place2 = new MarkerOptions().position(latlngEnd).zIndex(2.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.finish_icon));
        }
        addCircles();

    }



    @Override
    protected void onStop() {
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }

    private boolean service_stop=false;
    private boolean stoppressed=false;
    private boolean received=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        exitlout=(RelativeLayout) findViewById(R.id.exitlout);
        service_stop=false;
        stop = (Button) findViewById(R.id.stop);
        stop.setEnabled(false);
        crossexit=(Button)findViewById(R.id.exitbutton);
        progbar=(RelativeLayout)findViewById(R.id.progbar1);
        loadinglout=(RelativeLayout)findViewById(R.id.loadinglout);
        loadinglout.setVisibility(View.INVISIBLE);
        yes=(Button)findViewById(R.id.yes);
        no=(Button)findViewById(R.id.no);
        exitlout.setVisibility(View.GONE);
        gpscenter=(Button)findViewById(R.id.gpscenter);
        gpscenter.setVisibility(View.GONE);
        getLocationPermission();
        enable_buttons();
        addCircles();
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
        if(isMyServiceRunning(GPS_Service.class)==false) {
            Intent intent3= getIntent();
            waypts= (ArrayList<LatLng>) intent3.getExtras().get("waypts");
            if(waypts!=null){
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                latlngE=waypts.get(0).toString().substring(10,35);
                i.putExtra("latLngE", latlngE);
                startService(i);
            }else {
                Log.d(ATAG, "Dont");
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                Intent intent1 = getIntent();
                latlngE = (String) intent1.getExtras().get("latLngEnd");
                i.putExtra("latLngE", latlngE);
                startService(i);
            }
        }

    }
    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            UserInformation uInfo = new UserInformation();
            uInfo.setEndTime(ds.child(userID).getValue(UserInformation.class).getEndTime());
            strEndTime = uInfo.getEndTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                date = format.parse(strEndTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (currentTime.after(date)) {
finish();
            }
        }
    }
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
    private void addCircles() {
        if(broadcastReceiver2==null) {
            broadcastReceiver2 = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    if (received != true) {
                        received = true;
                        loadinglout.setVisibility(View.GONE);
                        progbar.setVisibility(View.GONE);
                        mMap.getUiSettings().setZoomGesturesEnabled(true);
                        mMap.getUiSettings().setScrollGesturesEnabled(true);
                        mMap.getUiSettings().setTiltGesturesEnabled(true);
                        mMap.getUiSettings().setRotateGesturesEnabled(true);
                        stop.setEnabled(true);
                        latLng1 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng1");   //Getting radius center coords
                        latLng2 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng2");
                        latLng4 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng4");
                        latLng5 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng5");
                        latLng6 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng6");
                        latLng7 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng7");
                        latLng8 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng8");
                        latLng9 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng9");
                        latLng10 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng10");
                        latLng11 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng11");
                        latLng12 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng12");
                        latLng13 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng13");
                        latLng14 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng14");
                        latLng15 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng15");
                        latLng16 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng16");
                        latLng17 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng17");
                        latLng18 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng18");
                        latLng19 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng19");
                        latLng20 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng20");
                        latLng21 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng21");
                        latLng22 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng22");
                        latLng23 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng23");
                        latLng24 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng24");
                        latLng25 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng25");
                        latLng26 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng26");
                        latLng27 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng27");
                        latLng28 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng28");
                        latLng29 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng29");
                        latLng30 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng30");
                        latLng31 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng31");
                        latLng32 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng32");
                        latLng33 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng33");
                        latLng34 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng34");
                        latLng35 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng35");
                        latLng36 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng36");
                        latLng37 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng37");
                        latLng38 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng38");
                        latLng39 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng39");
                        latLng40 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng40");
                        latLng41 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng41");
                        latLng42 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng42");
                        latLng43 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng43");
                        latLng44 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng44");
                        latLng45 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng45");
                        latLng46 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng46");
                        latLng47 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng47");
                        latLng48 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng48");
                        latLng49 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng49");
                        latLng50 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng50");
                        latLng51 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng51");
                        latLng52 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng52");

                        addMarkers2();
                    }
                }




            };
            registerReceiver(broadcastReceiver2, new IntentFilter("location_update"));
        }
    }

    private void addMarkers2() {
            mMap.addMarker(new MarkerOptions()
            .position(latLng1)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
            .title("LIVONIJAS ORDEŅA PILS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng2)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("RĀTSLAUKUMS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng4)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("STRŪKLAKA 'KUĢU VĒROTĀJS'"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng5)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng6)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS GALVENĀ BIBLIOTĒKA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng7)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS BRĪVOSTAS PĀRVALDE"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng8)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("JŪRAKMENS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng9)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng10)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS TIRGUS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng11)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("AMATU MĀJA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng12)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("PRĀMJU TERMINĀLIS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng13)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS DIGITĀLAIS CENTRS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng14)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS JAUNRADES NAMS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng15)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng16)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng17)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("PIEMINEKLIS JĀNIM FABRICIUSAM"));
        // Hotels and food -------------------------------------------------------------------------------
            mMap.addMarker(new MarkerOptions()
                    .position(latLng18)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("KUPFERNAMS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng19)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("KLOSTERIS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng20)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("MAZAIS NAMIŅŠ"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng21)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("ORANŽAIS NAMS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng22)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("PORTOSS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng23)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("DZINTARI"));
            //Food
            mMap.addMarker(new MarkerOptions()
                    .position(latLng24)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("LANDORA 6"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng25)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("ĒRMANĪTIS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng26)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("SKRODERKROGS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng27)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("DOLCE VITA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng28)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("BURGERBĀRS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng29)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("OSTAS 23"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng30)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS NIKOLAJA LUTERĀŅU BAZNĪCA"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng31)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("RĀTSGALDS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng32)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS LUTERĀŅU DRAUDZES NAMS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng33)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("VENTSPILS ALUS DARĪTAVA “COURLANDER”"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng34)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("AKA VENTSPILS TIRGUS LAUKUMĀ"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng35)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("ZVANU TORNIS TIRGUS LAUKUMĀ"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng36)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("GOVIS “PIE SPOGUĻA”"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng37)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("MĀRĪTES"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng38)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("SIEVIŠĶĪGĀ GOVS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng39)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("GOTIŅA ŠŪPOLĒS"));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng40)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .zIndex(1.0f)
                    .title("LATVIJAS MELNĀ"));
         mMap.addMarker(new MarkerOptions()
                .position(latLng41)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("LEMBERGA HŪTE"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng42)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("PĀRVENTAS BIBLIOTĒKA"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng43)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("JŪRAS STĀVKRASTI STALDZENĒ"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng44)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("PUĶU GOVS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng45)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("GAISMAS GOVS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng46)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("GOVS MATROZIS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng47)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("PIENA CEĻŠ GOVS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng48)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("VENTSPILS ZĀĻU GOVS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng49)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("GOVS CEĻOTĀJA"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng50)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("VENTSPILS 2. VIDUSSKOLA"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng51)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("PIEJŪRAS BRĪVDABAS MUZEJS"));
        mMap.addMarker(new MarkerOptions()
                .position(latLng52)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .zIndex(1.0f)
                .title("VENTSPILS MAZBĀNĪTIS"));

    }

    private void enable_buttons() {
        crossexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nopressed();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nopressed();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                stopService(i);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        gpscenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moved=false;
                gpscenter.setVisibility(View.GONE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exitlout.setVisibility(View.VISIBLE);
                gpscenter.setVisibility(View.GONE);
                mMap.getUiSettings().setZoomGesturesEnabled(false);
                mMap.getUiSettings().setScrollGesturesEnabled(false);
                mMap.getUiSettings().setTiltGesturesEnabled(false);
                mMap.getUiSettings().setRotateGesturesEnabled(false);
                service_stop=true;
                stoppressed=true;
            }
        });


    }

    private void nopressed() {
        if(moved!=false){
            gpscenter.setVisibility(View.VISIBLE);
        }
        stop.setVisibility(View.VISIBLE);
        exitlout.setVisibility(View.GONE);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        service_stop=false;
        stoppressed=false;
    }

    private void getDeviceLocation(){
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(mLocationPermissionsGranted){

                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            Location currentLocation = (Location) task.getResult();

                            if(latlngEnd!=null){
                                mMap.addMarker(place2);
                                moveCamera(latlngEnd,DEFAULT_ZOOM);
                                loadinglout.setVisibility(View.GONE);
                                progbar.setVisibility(View.VISIBLE);
                                mMap.getUiSettings().setZoomGesturesEnabled(true);
                                mMap.getUiSettings().setScrollGesturesEnabled(true);
                                mMap.getUiSettings().setTiltGesturesEnabled(true);
                                mMap.getUiSettings().setRotateGesturesEnabled(true);
                            }else{
                                moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                        DEFAULT_ZOOM);
                            }
                        }
                    }
                });
            }
        }catch (SecurityException e){
        }
    }

    private void moveCamera(LatLng latLng, float zoom){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    private void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MainActivity.this);
    }

    private void getLocationPermission(){
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionsGranted = true;
                    initMap();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startserv();
        if (broadcastReceiver == null) {
            broadcastReceiver = new BroadcastReceiver() {
                @SuppressLint("MissingPermission")
                @Override
                public void onReceive(Context context, Intent intent) {
                    String latLng = "\n" + intent.getExtras().get("coordinates");

                    String[] LatLng = latLng.split(",");
                    double latitude = Double.parseDouble(LatLng[0]); //Person coords
                    double longitude = Double.parseDouble(LatLng[1]);
                    checkIfRouteEnd();
                    latlng = new LatLng(longitude, latitude);
                    if(routeBoolean==true) {
                        if (latlng != null) {
                            place1 = new MarkerOptions().position(latlng).title("Location 1");
                            set_route();
                        }
                    }
                    float bearing = (float) intent.getExtras().get("bearing");
                    if (moved != true) {
                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(latlng)
                                .zoom(17)
                                .bearing(bearing)
                                .tilt(0)
                                .build();
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }

                    mMap.setMyLocationEnabled(true);
                }
            };
        }
        registerReceiver(broadcastReceiver, new IntentFilter("location_update"));
    }

    private void checkIfRouteEnd() {
        if(broadcastReceiver3==null){
            broadcastReceiver3=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    routeBoolean= (boolean) intent.getExtras().get("EndofRoute");
                    if(routeBoolean==false){
                        if(waypts!=null){
                            mMap.clear();
                            addMarkers2();
                            polylineOptions = new PolylineOptions();
                            polylineOptions.color(Color.BLUE);
                            polylineOptions.width(10);
                            polylineOptions.addAll(waypts);
                            mMap.addPolyline(polylineOptions);
                        }else {
                            mMap.clear();
                            addMarkers2();
                        }
                    }

                }
            };
            registerReceiver(broadcastReceiver3, new IntentFilter("EndOfRoute"));
        }
    }

    private void set_route() {

        if(ROUTE_PERMISSION==true) {
            new FetchURL(MainActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
        }
    }


    @Override
    public void onCameraMoveStarted(int reason) {
        if (service_stop = true) {
            if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_GESTURE) {
                moved = true;
                gpscenter.setVisibility(View.VISIBLE);
            } else if (reason == GoogleMap.OnCameraMoveStartedListener
                    .REASON_API_ANIMATION) {
                moved = true;
                gpscenter.setVisibility(View.VISIBLE);
            } else if (reason == GoogleMap.OnCameraMoveStartedListener
                    .REASON_DEVELOPER_ANIMATION) {
            }
        }
    }
    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;
    }

    @Override
    protected void onDestroy() {
        Intent i = new Intent(getApplicationContext(), GPS_Service.class);
        stopService(i);
        super.onDestroy();
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }
}
