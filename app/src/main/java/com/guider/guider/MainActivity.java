package com.guider.guider;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final String ATAG="Opened";
    private Button start,stop;
    private BroadcastReceiver broadcastReceiver;
    private Marker currentLocationMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);




        if(!runtime_permissions())
            enable_buttons();
    }
    private void enable_buttons() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),GPS_Service.class);
                startService(i);  //Start
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),GPS_Service.class);

                stopService(i);
            }
        });

    }

    private boolean runtime_permissions() {
        if(Build.VERSION.SDK_INT>=23 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED&&ContextCompat
                .checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},100);
            return true;
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);

        } else {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(broadcastReceiver==null){
            broadcastReceiver=new BroadcastReceiver() {


                @Override
                public void onReceive(Context context, Intent intent) {

                    String latLng="\n"+intent.getExtras().get("coordinates");
                    String[]LatLng=latLng.split(",");
                    double latitude = Double.parseDouble(LatLng[0]); //Person coords
                    double longitude = Double.parseDouble(LatLng[1]);
                    LatLng latlng = new LatLng(longitude,latitude);
                    if(currentLocationMarker != null){
                        currentLocationMarker.remove();
                    }
                    MarkerOptions marker = new MarkerOptions();
                    marker.position(latlng);
                    marker.title("You");
                    currentLocationMarker=mMap.addMarker(marker);
                    LatLng latLng1= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng1");   //Getting radius center coords
                    LatLng latLng2= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng2");
                    LatLng latLng3= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng3");
                    LatLng latLng4= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng4");
                    LatLng latLng5= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng5");
                    LatLng latLng6= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng6");
                    LatLng latLng7= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng7");
                    LatLng latLng8= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng8");
                    LatLng latLng9= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng9");
                    LatLng latLng10= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng10");
                    LatLng latLng11= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng11");
                    LatLng latLng12= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng12");
                    LatLng latLng13= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng13");
                    LatLng latLng14= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng14");
                    LatLng latLng15= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng15");
                    LatLng latLng16= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng16");
                    LatLng latLng17= (com.google.android.gms.maps.model.LatLng) intent.getExtras().get("latLng17");

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
            };
        }

        registerReceiver(broadcastReceiver,new IntentFilter("location_update"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(broadcastReceiver==null){
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {       //Asking permission for using GPS on the Phone;
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                    enable_buttons();
                    return;
                }

            } else {
                runtime_permissions();
            }
        }
    }
}
