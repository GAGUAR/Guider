    package com.guider.guider;
    import android.annotation.SuppressLint;
    import android.app.Notification;
    import android.app.NotificationChannel;
    import android.app.NotificationManager;
    import android.app.Service;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.location.Location;
    import android.location.LocationListener;
    import android.location.LocationManager;
    import android.os.Build;
    import android.os.Bundle;
    import android.os.IBinder;
    import android.provider.Settings;
    import android.support.annotation.Nullable;
    import android.support.v4.app.NotificationCompat;
    import android.util.Log;
    import com.google.android.gms.maps.model.LatLng;
    public class GPS_Service extends Service {
    private LocationListener listener;
    private String booleanGps = "1";
        private NotificationManager mNotificationManager;
        LatLng latlngEnd, latLng1, latLng2,latLng4,latLng5,latLng6,latLng7,latLng8,latLng9,latLng10,latLng11,latLng12,latLng13,latLng14,latLng15,latLng16,latLng17,latLng18,latLng19,latLng20,latLng21,
        latLng22,latLng23,latLng24,latLng25,latLng26,latLng27,latLng28,latLng29,latLng30,latLng31,latLng32,latLng33,latLng34,latLng35,latLng36,latLng37,latLng38,latLng39,latLng40,latLng41,latLng42,latLng43,latLng44,latLng45,latLng46,latLng47,latLng48,latLng49,latLng50,latLng51,latLng52;
        boolean opened1=false;
        boolean opened2=false;
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
        boolean opened30=false;
        boolean opened31=false;
        boolean opened32=false;
        boolean opened33=false;
        boolean opened34=false;
        boolean opened35=false;
        boolean opened36=false;
        boolean opened37=false;
        boolean opened38=false;
        boolean opened39=false;
        boolean opened40=false;
        boolean opened41=false;
        boolean opened42=false;
        boolean opened43=false;
        boolean opened44=false;
        boolean opened45=false;
        boolean opened46=false;
        boolean opened47=false;
        boolean opened48=false;
        boolean opened49=false;
        boolean opened50=false;
        boolean opened51=false;
        boolean opened52=false;
    private LocationManager manager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        String latLngE=(String) intent.getExtras().get("latLngE");
        if(latLngE!=null) {
            String[] LatLng = latLngE.split(",");
            double latitude = Double.parseDouble(LatLng[0]); //Person coords
            double longitude = Double.parseDouble(LatLng[1]);
            latlngEnd = new LatLng(latitude, longitude);
        }
        listener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                float[] distEnd = new float[2];
                float[] distance1 = new float[2];
                float[] distance2 = new float[2];
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
                float[] distance30 = new float[2];
                float[] distance31 = new float[2];
                float[] distance32 = new float[2];
                float[] distance33 = new float[2];
                float[] distance34 = new float[2];
                float[] distance35 = new float[2];
                float[] distance36 = new float[2];
                float[] distance37 = new float[2];
                float[] distance38 = new float[2];
                float[] distance39 = new float[2];
                float[] distance40 = new float[2];
                float[] distance41 = new float[2];
                float[] distance42 = new float[2];
                float[] distance43 = new float[2];
                float[] distance44 = new float[2];
                float[] distance45 = new float[2];
                float[] distance46 = new float[2];
                float[] distance47 = new float[2];
                float[] distance48 = new float[2];
                float[] distance49 = new float[2];
                float[] distance50 = new float[2];
                float[] distance51 = new float[2];
                float[] distance52 = new float[2];
                Intent intent = new Intent("location_update");
                intent.putExtra("coordinates", location.getLongitude() + "," + location.getLatitude());   //Sends local device coordinates to MainActivity
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                latLng1 = new LatLng(57.396120, 21.559253);    //100m
                latLng2 = new LatLng(57.395770, 21.567473);
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
                latLng16=new LatLng(57.398447, 21.572733);    //55m
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
                latLng30=new LatLng(57.396002, 21.567951);
                latLng31=new LatLng(57.395592, 21.567232);
                latLng32=new LatLng(57.396335, 21.567627);
                latLng33=new LatLng(57.397319, 21.567090);
                latLng34=new LatLng(57.397647, 21.567370);
                latLng35=new LatLng(57.397483, 21.568149);
                latLng36=new LatLng(57.398190, 21.569543);
                latLng37=new LatLng(57.398470, 21.568062);
                latLng38=new LatLng(57.398602, 21.567294);
                latLng39=new LatLng(57.398143, 21.565802);
                latLng40=new LatLng(57.398184, 21.565340);
                latLng41=new LatLng(57.375320, 21.548041);
                latLng42=new LatLng(57.403801, 21.591665);
                latLng43=new LatLng(57.444989, 21.605236);
                latLng44=new LatLng(57.388072, 21.582282);
                latLng45=new LatLng(57.393273, 21.564254);
                latLng46=new LatLng(57.400300, 21.529508);
                latLng47=new LatLng(57.393025, 21.541028);
                latLng48=new LatLng(57.403823, 21.591320);
                latLng49=new LatLng(57.395156, 21.553630);
                latLng50=new LatLng(57.387892, 21.566085);
                latLng51=new LatLng(57.385013, 21.537881);
                latLng52=new LatLng(57.376095, 21.548336);
                if(latlngEnd!=null){
                    Location.distanceBetween( latLng.latitude,latLng.longitude,
                            latlngEnd.latitude,latlngEnd.longitude, distEnd);
                        if (distEnd[0] > 50) {

                        } else {
                            Intent myIntent = new Intent("EndOfRoute");
                            boolean routeInProgress=false;
                            myIntent.putExtra("EndofRoute", routeInProgress);
                            sendBroadcast(myIntent);
                    }
                }
                Location.distanceBetween( latLng.latitude,latLng.longitude,       //Counts distance between GeoLocation and Radius
                        latLng1.latitude,latLng1.longitude, distance1);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng2.latitude,latLng2.longitude, distance2);
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
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng30.latitude,latLng30.longitude, distance30);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng31.latitude,latLng31.longitude, distance31);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng32.latitude,latLng32.longitude, distance32);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng33.latitude,latLng33.longitude, distance33);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng34.latitude,latLng34.longitude, distance34);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng35.latitude,latLng35.longitude, distance35);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng36.latitude,latLng36.longitude, distance36);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng37.latitude,latLng37.longitude, distance37);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng38.latitude,latLng38.longitude, distance38);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng39.latitude,latLng39.longitude, distance39);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng40.latitude,latLng40.longitude, distance40);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng41.latitude,latLng41.longitude, distance41);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng42.latitude,latLng42.longitude, distance42);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng43.latitude,latLng43.longitude, distance43);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng44.latitude,latLng44.longitude, distance44);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng45.latitude,latLng45.longitude, distance45);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng46.latitude,latLng46.longitude, distance46);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng47.latitude,latLng47.longitude, distance47);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng48.latitude,latLng48.longitude, distance48);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng49.latitude,latLng49.longitude, distance49);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng50.latitude,latLng50.longitude, distance50);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng51.latitude,latLng51.longitude, distance51);
                Location.distanceBetween( latLng.latitude,latLng.longitude,
                        latLng52.latitude,latLng52.longitude, distance52);

                    if (opened1 != true) {
                        if (distance1[0] > 100) {
                            opened1 = false;
                        } else {
                            String integer="1";
                            onComeActivity(integer,booleanGps);
                            opened1 = true;    //To prevent looped infinity opening( IF statement)
                        }
                    }
                    if (opened2 != true) {
                        if (distance2[0] > 35) {
                            opened2 = false;
                        } else {
                            String integer="2";
                            onComeActivity(integer,booleanGps);
                            opened2 = true;
                        }
                    }
                    if (opened4 != true) {
                        if (distance4[0] > 50) {
                            opened4 = false;
                        } else {
                            String integer="4";
                            onComeActivity(integer,booleanGps);
                            opened4 = true;
                        }
                    }
                    if (opened5 != true) {
                        if (distance5[0] > 30) {
                            opened5 = false;
                        } else {
                            String integer="5";
                            onComeActivity(integer,booleanGps);
                            opened5 = true;
                        }
                    }
                    if (opened6 != true) {
                        if (distance6[0] > 60) {
                            opened6 = false;
                        } else {
                            String integer="6";
                            onComeActivity(integer,booleanGps);
                            opened6 = true;
                        }
                    }
                    if (opened7 != true) {
                        if (distance7[0] > 40) {
                            opened7 = false;
                        } else {
                            String integer="7";
                            onComeActivity(integer,booleanGps);
                            opened7 = true;
                        }
                    }
                    if (opened8 != true) {
                        if (distance8[0] > 25) {
                            opened8 = false;
                        } else {
                            String integer="8";
                            onComeActivity(integer,booleanGps);
                            opened8 = true;
                        }
                    }
                    if (opened9 != true) {
                        if (distance9[0] > 20) {
                            opened9 = false;
                        } else {
                            String integer="9";
                            onComeActivity(integer,booleanGps);
                            opened9 = true;
                        }
                    }
                    if (opened10 != true) {
                        if (distance10[0] > 50) {
                            opened10 = false;
                        } else {
                            String integer="10";
                            onComeActivity(integer,booleanGps);
                            opened10 = true;
                        }
                    }
                    if (opened11 != true) {
                        if (distance11[0] > 30) {
                            opened11 = false;
                        } else {
                            String integer="11";
                            onComeActivity(integer,booleanGps);
                            opened11 = true;
                        }
                    }
                    if (opened12 != true) {
                        if (distance12[0] > 50) {
                            opened12 = false;
                        } else {
                            String integer="12";
                            onComeActivity(integer,booleanGps);
                            opened12 = true;
                        }
                    }
                    if (opened13 != true) {
                        if (distance13[0] > 25) {
                            opened13 = false;
                        } else {
                            String integer="13";
                            onComeActivity(integer,booleanGps);
                            opened13 = true;
                        }
                    }
                    if (opened14 != true) {
                        if (distance14[0] > 70) {
                            opened14 = false;
                        } else {
                            String integer="14";
                            onComeActivity(integer,booleanGps);
                            opened14 = true;
                        }
                    }
                    if (opened15 != true) {
                        if (distance15[0] > 30) {
                            opened15 = false;
                        } else {
                            String integer="15";
                            onComeActivity(integer,booleanGps);
                            opened15 = true;
                        }
                    }
                    if (opened16 != true) {
                        if (distance16[0] > 55) {
                            opened16 = false;
                        } else {
                            String integer="16";
                            onComeActivity(integer,booleanGps);
                            opened16 = true;
                        }
                    }
                    if (opened17 != true) {
                        if (distance17[0] > 20) {
                            opened17 = false;
                        } else {
                            String integer="17";
                            onComeActivity(integer,booleanGps);
                            opened17 = true;
                        }
                    }
                    if (opened18 != true) {
                        if (distance18[0] > 40) {
                            opened18 = false;
                        } else {
                            String integer="18";
                            onComeActivity(integer,booleanGps);
                            opened18 = true;
                        }
                    }
                    if (opened19 != true) {
                        if (distance19[0] > 40) {
                            opened19 = false;
                        } else {
                            String integer="19";
                            onComeActivity(integer,booleanGps);
                            opened19 = true;
                        }
                    }
                    if (opened20 != true) {
                        if (distance20[0] > 40) {
                            opened20 = false;
                        } else {
                            String integer="20";
                            onComeActivity(integer,booleanGps);
                            opened20 = true;
                        }
                    }
                    if (opened21 != true) {
                        if (distance21[0] > 40) {
                            opened21 = false;
                        } else {
                            String integer="21";
                            onComeActivity(integer,booleanGps);
                            opened21 = true;
                        }
                    }
                    if (opened22 != true) {
                        if (distance22[0] > 40) {
                            opened22 = false;
                        } else {
                            String integer="22";
                            onComeActivity(integer,booleanGps);
                            opened22 = true;
                        }
                    }
                if(opened23!=true) {
                    if (distance23[0] > 40) {
                        opened23 = false;
                    } else {
                        String integer="23";
                        onComeActivity(integer,booleanGps);
                        opened23 = true;
                    }
                }
                    if (opened24 != true) {
                        if (distance24[0] > 25) {
                            opened24 = false;
                        } else {
                            String integer="24";
                            onComeActivity(integer,booleanGps);
                            opened24 = true;
                        }
                    }
                    if (opened25 != true) {
                        if (distance25[0] > 30) {
                            opened25 = false;
                        } else {
                            String integer="25";
                            onComeActivity(integer,booleanGps);
                            opened25 = true;
                        }
                    }
                    if (opened26 != true) {
                        if (distance26[0] > 40) {
                            opened26 = false;
                        } else {
                            String integer="26";
                            onComeActivity(integer,booleanGps);
                            opened26 = true;
                        }
                    }
                    if (opened27 != true) {
                        if (distance27[0] > 15) {
                            opened27 = false;
                        } else {
                            String integer="27";
                            onComeActivity(integer,booleanGps);
                            opened27 = true;
                        }
                    }
                    if (opened28 != true) {
                        if (distance28[0] > 15) {
                            opened28 = false;
                        } else {
                            String integer="28";
                            onComeActivity(integer,booleanGps);
                            opened28 = true;
                        }
                    }
                    if (opened29 != true) {
                        if (distance29[0] > 40) {
                            opened29 = false;
                        } else {
                            String integer="29";
                            onComeActivity(integer,booleanGps);
                            opened29 = true;
                        }
                    }
                    if (opened30 != true) {
                        if (distance30[0] > 55) {
                            opened30 = false;
                        } else {
                            String integer="30";
                            onComeActivity(integer,booleanGps);
                            opened30 = true;
                        }
                    }
                    if (opened31 != true) {
                        if (distance31[0] > 35) {
                            opened31 = false;
                        } else {
                            String integer="31";
                            onComeActivity(integer,booleanGps);
                            opened31 = true;
                        }
                    }
                if (opened32 != true) {
                    if (distance32[0] > 25) {
                        opened32 = false;
                    } else {
                        String integer="32";
                        onComeActivity(integer,booleanGps);
                        opened32 = true;
                    }
                }
                if (opened33 != true) {
                    if (distance33[0] > 15) {
                        opened33 = false;
                    } else {
                        String integer="33";
                        onComeActivity(integer,booleanGps);
                        opened33 = true;
                    }
                }

                if (opened34 != true) {
                    if (distance34[0] > 10) {
                        opened34 = false;
                    } else {
                        String integer="34";
                        onComeActivity(integer,booleanGps);
                        opened34 = true;
                    }
                }
                if (opened35 != true) {
                    if (distance35[0] > 20) {
                        opened35 = false;
                    } else {
                        String integer="35";
                        onComeActivity(integer,booleanGps);
                        opened35 = true;
                    }
                }
                if (opened36 != true) {
                    if (distance36[0] > 10) {
                        opened36 = false;
                    } else {
                        String integer="36";
                        onComeActivity(integer,booleanGps);
                        opened36 = true;
                    }
                }
                if (opened37 != true) {
                    if (distance37[0] > 30) {
                        opened37 = false;
                    } else {
                        String integer="37";
                        onComeActivity(integer,booleanGps);
                        opened37 = true;
                    }
                }
                if (opened38 != true) {
                    if (distance38[0] > 10) {
                        opened38 = false;
                    } else {
                        String integer="38";
                        onComeActivity(integer,booleanGps);
                        opened38 = true;
                    }
                }
                if (opened39 != true) {
                    if (distance39[0] > 15) {
                        opened39 = false;
                    } else {
                        String integer="39";
                        onComeActivity(integer,booleanGps);
                        opened39 = true;
                    }
                }
                if (opened40 != true) {
                    if (distance40[0] > 15) {
                        opened40 = false;
                    } else {
                        String integer="40";
                        onComeActivity(integer,booleanGps);
                        opened40 = true;
                    }
                }
                if (opened41 != true) {
                    if (distance41[0] > 15) {
                        opened41 = false;
                    } else {
                        String integer="41";
                        onComeActivity(integer,booleanGps);
                        opened41 = true;
                    }
                }
                if (opened42 != true) {
                    if (distance42[0] > 15) {
                        opened42 = false;
                    } else {
                        String integer="42";
                        onComeActivity(integer,booleanGps);
                        opened42 = true;
                    }
                }
                if (opened43 != true) {
                    if (distance43[0] > 15) {
                        opened43 = false;
                    } else {
                        String integer="43";
                        onComeActivity(integer,booleanGps);
                        opened43 = true;
                    }
                }
                if (opened44 != true) {
                    if (distance44[0] > 15) {
                        opened44 = false;
                    } else {
                        String integer="44";
                        onComeActivity(integer,booleanGps);
                        opened44 = true;
                    }
                }
                if (opened45 != true) {
                    if (distance45[0] > 15) {
                        opened45 = false;
                    } else {
                        String integer="45";
                        onComeActivity(integer,booleanGps);
                        opened45 = true;
                    }
                }
                if (opened46 != true) {
                    if (distance46[0] > 15) {
                        opened46 = false;
                    } else {
                        String integer="46";
                        onComeActivity(integer,booleanGps);
                        opened46 = true;
                    }
                }
                if (opened47 != true) {
                    if (distance47[0] > 15) {
                        opened47 = false;
                    } else {
                        String integer="47";
                        onComeActivity(integer,booleanGps);
                        opened47 = true;
                    }
                }
                if (opened48 != true) {
                    if (distance48[0] > 15) {
                        opened48 = false;
                    } else {
                        String integer="48";
                        onComeActivity(integer,booleanGps);
                        opened48 = true;
                    }
                }
                if (opened49 != true) {
                    if (distance49[0] > 15) {
                        opened49 = false;
                    } else {
                        String integer="49";
                        onComeActivity(integer,booleanGps);
                        opened49 = true;
                    }
                }
                if (opened50 != true) {
                    if (distance50[0] > 30) {
                        opened50 = false;
                    } else {
                        String integer="50";
                        onComeActivity(integer,booleanGps);
                        opened50 = true;
                    }
                }
                if (opened51 != true) {
                    if (distance51[0] > 30) {
                        opened51 = false;
                    } else {
                        String integer="51";
                        onComeActivity(integer,booleanGps);
                        opened51 = true;
                    }
                }
                if (opened52 != true) {
                    if (distance52[0] > 15) {
                        opened52 = false;
                    } else {
                        String integer="52";
                        onComeActivity(integer,booleanGps);
                        opened52 = true;
                    }
                }



                intent.putExtra("latLng1", latLng1);
                intent.putExtra("latLng2", latLng2);
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
                intent.putExtra("latLng30", latLng30);
                intent.putExtra("latLng31", latLng31);
                intent.putExtra("latLng32", latLng32);
                intent.putExtra("latLng33", latLng33);
                intent.putExtra("latLng34", latLng34);
                intent.putExtra("latLng35", latLng35);
                intent.putExtra("latLng36", latLng36);
                intent.putExtra("latLng37", latLng37);
                intent.putExtra("latLng38", latLng38);
                intent.putExtra("latLng39", latLng39);
                intent.putExtra("latLng40", latLng40);
                intent.putExtra("latLng41", latLng41);
                intent.putExtra("latLng42", latLng42);
                intent.putExtra("latLng43", latLng43);
                intent.putExtra("latLng44", latLng44);
                intent.putExtra("latLng45", latLng45);
                intent.putExtra("latLng46", latLng46);
                intent.putExtra("latLng47", latLng47);
                intent.putExtra("latLng48", latLng48);
                intent.putExtra("latLng49", latLng49);
                intent.putExtra("latLng50", latLng50);
                intent.putExtra("latLng51", latLng51);
                intent.putExtra("latLng52", latLng52);
                intent.putExtra("bearing",location.getBearing());
                boolean started=true;
                intent.putExtra("started",started);
                sendBroadcast(intent); //sending  all coordinate data
            }
                private void onComeActivity(String integer, String booleanGps) {
                Intent myIntent = new Intent(getApplicationContext(), InfoActivities.class);
                Bundle extras = new Bundle();
                extras.putString("integers", integer);
                extras.putString("booleanGps", booleanGps);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myIntent.putExtras(extras);
                startActivity(myIntent);
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
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this.getApplicationContext(), "notify_001");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle("Guider");
        mBuilder.setOngoing(true);
        mBuilder.setContentText("Guider ekskursija ir aktīva");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "Guider";
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Guider Tours",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }
        mNotificationManager.notify(0, mBuilder.build());
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(manager!=null){
            manager.removeUpdates(listener);
            mNotificationManager.cancel(0);
            }
        }
    }