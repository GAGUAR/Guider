package com.guider.guider;


import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener {

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
            mMap.setMyLocationEnabled(true);
            mMap.setMyLocationEnabled(true);
            mMap.setOnCameraMoveStartedListener(this);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
        }
    }

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private static final String ATAG = "Opened";
    private Button start, stop, search, gpscenter, yes, no,crossexit;
    private BroadcastReceiver broadcastReceiver;
    private RelativeLayout exitlout;
    private RelativeLayout loadinglout;
    private Marker currentLocationMarker;
    private boolean sightseeing = true;
    private boolean food = true;
    private boolean hotels = true;
    private boolean moved=false;
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private boolean stopserv=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        exitlout=(RelativeLayout) findViewById(R.id.exitlout);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        crossexit=(Button)findViewById(R.id.exitbutton);
        loadinglout=(RelativeLayout)findViewById(R.id.loadinglout);
        loadinglout.setVisibility(View.INVISIBLE);
        search = (Button) findViewById(R.id.searchButton);
        stop.setVisibility(View.INVISIBLE);
        search.setVisibility(View.INVISIBLE);
        yes=(Button)findViewById(R.id.yes);
        no=(Button)findViewById(R.id.no);
        exitlout.setVisibility(View.INVISIBLE);
        gpscenter=(Button)findViewById(R.id.gpscenter);
        gpscenter.setVisibility(View.GONE);
        getLocationPermission();
        enable_buttons();
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
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                startService(i);
                start.setVisibility(View.INVISIBLE);
                stop.setVisibility(View.VISIBLE);
                    loadinglout.setVisibility(View.VISIBLE);
                mMap.getUiSettings().setZoomGesturesEnabled(false);
                mMap.getUiSettings().setScrollGesturesEnabled(false);
                mMap.getUiSettings().setTiltGesturesEnabled(false);
                mMap.getUiSettings().setRotateGesturesEnabled(false);
                stopserv=true;
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search.setVisibility(View.INVISIBLE);//Stop GPS Services
                exitlout.setVisibility(View.VISIBLE);
                gpscenter.setVisibility(View.GONE);
                mMap.getUiSettings().setZoomGesturesEnabled(false);
                mMap.getUiSettings().setScrollGesturesEnabled(false);
                mMap.getUiSettings().setTiltGesturesEnabled(false);
                mMap.getUiSettings().setRotateGesturesEnabled(false);
                stopserv=true;
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, search);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intentaim = new Intent(getApplicationContext(), GPS_Service.class);
                        switch (item.getItemId()) {
                            case R.id.all:
                                mMap.clear();
                                sightseeing = true;
                                food = true;
                                hotels = true;
                                intentaim.putExtra("sightseeing", sightseeing);
                                intentaim.putExtra("food", food);
                                intentaim.putExtra("hotels", hotels);
                                sendBroadcast(intentaim);
                                return true;
                            case R.id.sightseeing:
                                mMap.clear();
                                sightseeing = true;
                                food = false;
                                hotels = false;
                                intentaim.putExtra("sightseeing", sightseeing);
                                intentaim.putExtra("food", food);
                                intentaim.putExtra("hotels", hotels);
                                sendBroadcast(intentaim);
                                return true;
                            case R.id.hotels:
                                mMap.clear();
                                sightseeing = false;
                                food = false;
                                hotels = true;
                                intentaim.putExtra("sightseeing", sightseeing);
                                intentaim.putExtra("food", food);
                                intentaim.putExtra("hotels", hotels);
                                sendBroadcast(intentaim);
                                return true;
                            case R.id.food:
                                mMap.clear();
                                sightseeing = false;
                                food = true;
                                hotels = false;
                                intentaim.putExtra("sightseeing", sightseeing);
                                intentaim.putExtra("food", food);
                                intentaim.putExtra("hotels", hotels);
                                sendBroadcast(intentaim);
                                return true;
                            default:
                                return false;

                        }

                    }

                });

                popupMenu.show();
                //sending  all coordinate data
            }
        });

    }

    private void nopressed() {
        if(moved!=false){
            gpscenter.setVisibility(View.VISIBLE);
        }
        stop.setVisibility(View.VISIBLE);
        search.setVisibility(View.VISIBLE);
        exitlout.setVisibility(View.INVISIBLE);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        stopserv=false;
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
                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM);
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

        if (broadcastReceiver == null) {
            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String latLng = "\n" + intent.getExtras().get("coordinates");
                    if(latLng!=null){
                        loadinglout.setVisibility(View.INVISIBLE);
                        if(stopserv!=true) {
                            search.setVisibility(View.VISIBLE);
                        }
                        mMap.getUiSettings().setZoomGesturesEnabled(true);
                        mMap.getUiSettings().setScrollGesturesEnabled(true);
                        mMap.getUiSettings().setTiltGesturesEnabled(true);
                        mMap.getUiSettings().setRotateGesturesEnabled(true);

                    }
                    String[] LatLng = latLng.split(",");
                    double latitude = Double.parseDouble(LatLng[0]); //Person coords
                    double longitude = Double.parseDouble(LatLng[1]);
                    LatLng latlng = new LatLng(longitude, latitude);
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

                    if (currentLocationMarker != null) {
                        currentLocationMarker.remove();
                    }
                    MarkerOptions marker = new MarkerOptions();
                    marker.position(latlng);
                    marker.title("You");
                    currentLocationMarker = mMap.addMarker(marker);

                    LatLng latLng1 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng1");   //Getting radius center coords
                    LatLng latLng2 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng2");
                    LatLng latLng3 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng3");
                    LatLng latLng4 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng4");
                    LatLng latLng5 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng5");
                    LatLng latLng6 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng6");
                    LatLng latLng7 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng7");
                    LatLng latLng8 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng8");
                    LatLng latLng9 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng9");
                    LatLng latLng10 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng10");
                    LatLng latLng11 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng11");
                    LatLng latLng12 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng12");
                    LatLng latLng13 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng13");
                    LatLng latLng14 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng14");
                    LatLng latLng15 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng15");
                    LatLng latLng16 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng16");
                    LatLng latLng17 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng17");
                    LatLng latLng18 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng18");
                    LatLng latLng19 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng19");
                    LatLng latLng20 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng20");
                    LatLng latLng21 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng21");
                    LatLng latLng22 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng22");
                    LatLng latLng23 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng23");
                    LatLng latLng24 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng24");
                    LatLng latLng25 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng25");
                    LatLng latLng26 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng26");
                    LatLng latLng27 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng27");
                    LatLng latLng28 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng28");
                    LatLng latLng29 = (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng29");
                    if (sightseeing == true) {
                        mMap.addCircle(new CircleOptions()    //Drawing Circles on Map
                                .center(latLng1)
                                .radius(100)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng2)
                                .radius(35)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng4)
                                .radius(50)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng5)
                                .radius(30)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng6)
                                .radius(60)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng7)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng8)
                                .radius(25)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng9)
                                .radius(20)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng10)
                                .radius(50)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng11)
                                .radius(30)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng12)
                                .radius(50)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng13)
                                .radius(25)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng14)
                                .radius(70)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng15)
                                .radius(30)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng16)
                                .radius(55)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng17)
                                .radius(20)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                    }
                    // Hotels and food -------------------------------------------------------------------------------
                    if (hotels == true) {
                        mMap.addCircle(new CircleOptions()
                                .center(latLng18)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng19)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng20)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng21)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng22)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng23)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                    }
                    if (food == true) {
                        //Food
                        mMap.addCircle(new CircleOptions()
                                .center(latLng24)
                                .radius(25)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng25)
                                .radius(30)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng26)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng27)
                                .radius(15)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng28)
                                .radius(15)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );
                        mMap.addCircle(new CircleOptions()
                                .center(latLng29)
                                .radius(40)
                                .strokeColor(Color.BLACK)
                                .strokeWidth(2.0f)
                        );

                    }
                }
            };
        }

        registerReceiver(broadcastReceiver, new IntentFilter("location_update"));
    }
    @Override
    public void onCameraMoveStarted(int reason) {
        if (stopserv = true) {
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
}