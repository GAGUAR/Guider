    package com.guider.guider;

    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.app.Notification;
    import android.app.PendingIntent;
    import android.app.Service;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.location.Location;
    import android.location.LocationListener;
    import android.location.LocationManager;
    import android.os.Bundle;
    import android.os.IBinder;
    import android.os.SystemClock;
    import android.provider.Settings;
    import android.support.annotation.Nullable;
    import android.support.v4.app.NotificationCompat;
    import android.util.Log;
    import android.widget.Toast;

    import com.firebase.geofire.GeoFire;
    import com.firebase.geofire.GeoLocation;
    import com.firebase.geofire.GeoQuery;
    import com.firebase.geofire.GeoQueryEventListener;
    import com.google.android.gms.maps.model.LatLng;

    import com.google.firebase.database.DatabaseError;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;
    import com.google.maps.android.SphericalUtil;

    import java.util.ArrayList;

    import static com.guider.guider.App.CHANNEL_ID;


    public class GPS_Service extends Service {
    private LocationListener listener;
    private BroadcastReceiver broadcastReceiver1;
    private static final String TAG="MyLogs";
        private boolean sightseeing=true;
        private boolean food=true;
        private boolean hotels=true;
    LatLng latLng1;
    LatLng latLng2;
    LatLng latLng3;
        LatLng latLng4;
        LatLng latLng5;
        LatLng latLng6;
        LatLng latLng7;
        LatLng latLng8;
        LatLng latLng9;
        LatLng latLng10;
        LatLng latLng11;
        LatLng latLng12;
        LatLng latLng13;
        LatLng latLng14;
        LatLng latLng15;
        LatLng latLng16;
        LatLng latLng17;
        LatLng latLng18;
        LatLng latLng19;
        LatLng latLng20;
        LatLng latLng21;
        LatLng latLng22;
        LatLng latLng23;
        LatLng latLng24;
        LatLng latLng25;
        LatLng latLng26;
        LatLng latLng27;
        LatLng latLng28;
        LatLng latLng29;

    boolean opened1=false;
        boolean opened2=false;
        boolean opened3=false;
        boolean opened4=false;
        boolean opened5=false;
        boolean opened6=false;
        boolean opened7=false;
        boolean opened8=false;
        boolean opened9=false;
        boolean opened10=false;
        boolean opened11=false;
        boolean opened12=false;
        boolean opened13=false;
        boolean opened14=false;
        boolean opened15=false;
        boolean opened16=false;
        boolean opened17=false;
        boolean opened18=false;
        boolean opened19=false;
        boolean opened20=false;
        boolean opened21=false;
        boolean opened22=false;
        boolean opened23=false;
        boolean opened24=false;
        boolean opened25=false;
        boolean opened26=false;
        boolean opened27=false;
        boolean opened28=false;
        boolean opened29=false;


        DatabaseReference ref;
        GeoFire geoFire;
    private LocationManager manager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        ref = FirebaseDatabase.getInstance().getReference("MyLocation");
        geoFire=new GeoFire(ref);
        Intent notificationIntent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,
                0,notificationIntent,0);
        listener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(broadcastReceiver1==null){
                    new BroadcastReceiver() {
                        @Override
                        public void onReceive(Context context, Intent intent) {
                            sightseeing = (boolean) intent.getExtras().get("sightseeing");
                            food = (boolean) intent.getExtras().get("food");
                            hotels = (boolean) intent.getExtras().get("hotels");
                        }
                    };
                }
                float[] distance1 = new float[2];
                float[] distance2 = new float[2];
                float[] distance3 = new float[2];
                float[] distance4 = new float[2];
                float[] distance5 = new float[2];
                float[] distance6 = new float[2];
                float[] distance7 = new float[2];
                float[] distance8 = new float[2];
                float[] distance9 = new float[2];
                float[] distance10 = new float[2];
                float[] distance11 = new float[2];
                float[] distance12 = new float[2];
                float[] distance13 = new float[2];
                float[] distance14 = new float[2];
                float[] distance15 = new float[2];
                float[] distance16 = new float[2];
                float[] distance17 = new float[2];
                float[] distance18 = new float[2];
                float[] distance19 = new float[2];
                float[] distance20 = new float[2];
                float[] distance21 = new float[2];
                float[] distance22 = new float[2];
                float[] distance23 = new float[2];
                float[] distance24 = new float[2];
                float[] distance25 = new float[2];
                float[] distance26 = new float[2];
                float[] distance27 = new float[2];
                float[] distance28 = new float[2];
                float[] distance29 = new float[2];



                Intent intent = new Intent("location_update");

                intent.putExtra("coordinates", location.getLongitude() + "," + location.getLatitude());   //Sends local device coordinates to MainActivity
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                latLng1 = new LatLng(57.396120, 21.559253);    //100m
                latLng2 = new LatLng(57.395770, 21.567473);
                latLng3=new LatLng(57.396640, 21.567522);
                latLng4=new LatLng(57.397867, 21.564248);
                latLng5=new LatLng(57.395945, 21.566950);
                latLng6=new LatLng(57.396338, 21.566739);        //60m
                latLng7=new LatLng(57.396530, 21.560201);          //40m
                latLng8=new LatLng(57.398503, 21.568876);    //40m
                latLng9=new LatLng(57.396985, 21.560243);   //20m
                latLng10=new LatLng(57.397106, 21.568135);
                latLng11=new LatLng(57.397534, 21.566263);
                latLng12=new LatLng(57.398361, 21.569650);
                latLng13=new LatLng(57.396078, 21.566493);         //40m
                latLng14=new LatLng(57.395365, 21.563156);   //70m
                latLng15=new LatLng(57.394795, 21.551473);      //30m
                latLng16=new LatLng(57.396254, 21.567992);    //55m
                latLng17=new LatLng(57.396350, 21.566161);      //30m
                latLng18=new LatLng(57.393944, 21.563573);
                latLng19=new LatLng(57.395355, 21.557619);
                latLng20=new LatLng(57.393611, 21.544619);
                latLng21=new LatLng(57.391978, 21.544134);
                latLng22=new LatLng(57.389321, 21.542962);
                latLng23=new LatLng(57.390291, 21.556095);
                latLng24=new LatLng(57.394999, 21.565962);
                latLng25=new LatLng(57.392392, 21.559977);
                latLng26=new LatLng(57.395302, 21.564229);
                latLng27=new LatLng(57.394781, 21.567159);
                latLng28=new LatLng(57.396416, 21.565055);
                latLng29=new LatLng(57.396636, 21.560647);

                Location.distanceBetween( latLng.latitude,latLng.longitude,       //Counts distance between GeoLocation and Radius
                        latLng1.latitude,latLng1.longitude, distance1);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng2.latitude,latLng2.longitude, distance2);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng3.latitude,latLng3.longitude, distance3);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng4.latitude,latLng4.longitude, distance4);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng5.latitude,latLng5.longitude, distance5);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng6.latitude,latLng6.longitude, distance6);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng7.latitude,latLng7.longitude, distance7);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng8.latitude,latLng8.longitude, distance8);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng9.latitude,latLng9.longitude, distance9);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng10.latitude,latLng10.longitude, distance10);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng11.latitude,latLng11.longitude, distance11);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng12.latitude,latLng12.longitude, distance12);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng13.latitude,latLng13.longitude, distance13);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng14.latitude,latLng14.longitude, distance14);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng15.latitude,latLng15.longitude, distance15);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng16.latitude,latLng16.longitude, distance16);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng17.latitude,latLng17.longitude, distance17);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng18.latitude,latLng18.longitude, distance18);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng19.latitude,latLng19.longitude, distance19);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng20.latitude,latLng20.longitude, distance20);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng21.latitude,latLng21.longitude, distance21);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng22.latitude,latLng22.longitude, distance22);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng23.latitude,latLng23.longitude, distance23);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng24.latitude,latLng24.longitude, distance24);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng25.latitude,latLng25.longitude, distance25);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng26.latitude,latLng26.longitude, distance26);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng27.latitude,latLng27.longitude, distance27);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng28.latitude,latLng28.longitude, distance28);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng29.latitude,latLng29.longitude, distance29);
                if(sightseeing==true) {
                    if (opened1 != true) {
                        if (distance1[0] > 100) {

                            opened1 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "1");     //IF in Radius open InfoActivity and sent activityInterger to set text and image
                            startActivity(myIntent);
                            opened1 = true;    //To prevent looped infinity opening( IF statement)


                        }
                    }
                    if (opened2 != true) {
                        if (distance2[0] > 35) {

                            opened2 = false;
                        } else {

                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "2");
                            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(myIntent);
                            opened2 = true;


                        }
                    }

                    if (opened4 != true) {
                        if (distance4[0] > 50) {

                            opened4 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "4");
                            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(myIntent);
                            opened4 = true;


                        }
                    }
                    if (opened5 != true) {
                        if (distance5[0] > 30) {

                            opened5 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "5");
                            startActivity(myIntent);

                            opened5 = true;


                        }
                    }
                    if (opened6 != true) {
                        if (distance6[0] > 60) {

                            opened6 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "6");
                            startActivity(myIntent);

                            opened6 = true;

                        }
                    }
                    if (opened7 != true) {
                        if (distance7[0] > 40) {

                            opened7 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "7");
                            startActivity(myIntent);

                            opened7 = true;


                        }
                    }
                    if (opened8 != true) {
                        if (distance8[0] > 25) {

                            opened8 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "8");
                            startActivity(myIntent);
                            opened8 = true;


                        }
                    }
                    if (opened9 != true) {
                        if (distance9[0] > 20) {

                            opened9 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "9");
                            startActivity(myIntent);
                            opened9 = true;


                        }
                    }
                    if (opened10 != true) {
                        if (distance10[0] > 50) {

                            opened10 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "10");
                            startActivity(myIntent);
                            opened10 = true;


                        }
                    }
                    if (opened11 != true) {
                        if (distance11[0] > 30) {

                            opened11 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "11");
                            startActivity(myIntent);
                            opened11 = true;


                        }
                    }
                    if (opened12 != true) {
                        if (distance12[0] > 50) {

                            opened12 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "12");
                            startActivity(myIntent);
                            opened12 = true;
                        }
                    }
                    if (opened13 != true) {
                        if (distance13[0] > 25) {

                            opened13 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "13");
                            startActivity(myIntent);
                            opened13 = true;
                        }
                    }
                    if (opened14 != true) {
                        if (distance14[0] > 70) {

                            opened14 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "14");
                            startActivity(myIntent);
                            opened14 = true;
                        }
                    }
                    if (opened15 != true) {
                        if (distance15[0] > 30) {

                            opened15 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "15");
                            startActivity(myIntent);
                            opened15 = true;
                        }
                    }
                    if (opened16 != true) {
                        if (distance16[0] > 55) {

                            opened16 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "16");
                            startActivity(myIntent);
                            opened16 = true;
                        }
                    }
                }

                    if (opened17 != true) {
                        if (distance17[0] > 20) {

                            opened17 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "17");
                            startActivity(myIntent);

                            opened17 = true;
                        }
                    }
                if(hotels==true) {
                    if (opened18 != true) {
                        if (distance18[0] > 40) {

                            opened18 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "18");
                            startActivity(myIntent);

                            opened18 = true;
                        }
                    }
                    if (opened19 != true) {
                        if (distance19[0] > 40) {

                            opened19 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "19");
                            startActivity(myIntent);

                            opened19 = true;
                        }
                    }
                    if (opened20 != true) {
                        if (distance20[0] > 40) {

                            opened20 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "20");
                            startActivity(myIntent);

                            opened20 = true;
                        }
                    }
                    if (opened21 != true) {
                        if (distance21[0] > 40) {

                            opened21 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "21");
                            startActivity(myIntent);

                            opened21 = true;
                        }
                    }
                    if (opened22 != true) {
                        if (distance22[0] > 40) {

                            opened22 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "22");
                            startActivity(myIntent);

                            opened22 = true;
                        }
                    }
                }

                if(opened23!=true) {
                    if (distance23[0] > 40) {

                        opened23 = false;
                    } else {
                        Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                        myIntent.putExtra("integers","23");
                        startActivity(myIntent);

                        opened23 = true;
                    }
                }
                if(food==true) {
                    if (opened24 != true) {
                        if (distance24[0] > 25) {

                            opened24 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "24");
                            startActivity(myIntent);

                            opened24 = true;
                        }
                    }
                    if (opened25 != true) {
                        if (distance25[0] > 30) {

                            opened25 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "25");
                            startActivity(myIntent);

                            opened25 = true;
                        }
                    }
                    if (opened26 != true) {
                        if (distance26[0] > 40) {

                            opened26 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "26");
                            startActivity(myIntent);

                            opened26 = true;
                        }
                    }
                    if (opened27 != true) {
                        if (distance27[0] > 15) {

                            opened27 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "27");
                            startActivity(myIntent);

                            opened27 = true;
                        }
                    }
                    if (opened28 != true) {
                        if (distance28[0] > 15) {

                            opened28 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "28");
                            startActivity(myIntent);

                            opened28 = true;
                        }
                    }
                    if (opened29 != true) {
                        if (distance29[0] > 40) {

                            opened29 = false;
                        } else {
                            Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                            myIntent.putExtra("integers", "29");
                            startActivity(myIntent);

                            opened29 = true;
                        }
                    }
                }
                intent.putExtra("latLng1", latLng1);
                intent.putExtra("latLng2", latLng2);
                intent.putExtra("latLng3", latLng3);
                intent.putExtra("latLng4", latLng4);
                intent.putExtra("latLng5", latLng5);
                intent.putExtra("latLng6", latLng6);
                intent.putExtra("latLng7", latLng7);
                intent.putExtra("latLng8", latLng8);
                intent.putExtra("latLng9", latLng9);
                intent.putExtra("latLng10", latLng10);   //Putting zones centers coords
                intent.putExtra("latLng11", latLng11);
                intent.putExtra("latLng12", latLng12);
                intent.putExtra("latLng13", latLng13);
                intent.putExtra("latLng14", latLng14);
                intent.putExtra("latLng15", latLng15);
                intent.putExtra("latLng16", latLng16);
                intent.putExtra("latLng17", latLng17);
                intent.putExtra("latLng18", latLng18);
                intent.putExtra("latLng19", latLng19);
                intent.putExtra("latLng20", latLng20);
                intent.putExtra("latLng21", latLng21);
                intent.putExtra("latLng22", latLng22);
                intent.putExtra("latLng23", latLng23);
                intent.putExtra("latLng24", latLng24);
                intent.putExtra("latLng25", latLng25);
                intent.putExtra("latLng26", latLng26);
                intent.putExtra("latLng27", latLng27);
                intent.putExtra("latLng28", latLng28);
                intent.putExtra("latLng29", latLng29);

                sendBroadcast(intent); //sending  all coordinate data


                }



            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {          //Creating notification for GPS_Service
                Intent i=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        };
        manager=(LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,listener);
        Notification notification=new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Guider")
                .setContentText("Tour is in process")
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

        return START_STICKY;

    }



        @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        super.onCreate();
        /*
        */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(manager!=null){
            manager.removeUpdates(listener);


            }
        }
    }
