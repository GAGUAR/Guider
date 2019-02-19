package com.guider.guider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class InfoActivities extends AppCompatActivity{
    private TextView infotext;
    private ImageView infoImage;
    private static final String TAG="MyLogs";
    private int fromGpsNo;
    private String objLatLng;
    private String telephone=null;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activities);
        Button done = (Button) findViewById(R.id.donebtn);
        Button phone = (Button) findViewById(R.id.phoneButton);
        TextView titletext = (TextView) findViewById(R.id.titletext);
        TextView secondinfo = (TextView) findViewById(R.id.infotext2);
        TextView scndinfotitle = (TextView) findViewById(R.id.secondinfo);
        scndinfotitle.setVisibility(View.GONE);
        secondinfo.setVisibility(View.GONE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        infotext = (TextView) findViewById(R.id.infotext);
        infoImage = (ImageView) findViewById(R.id.infoimage);

        Bundle extras = getIntent().getExtras();
        String activityString = extras.getString("integers");
        String fromGps = extras.getString("booleanGps");
        fromGpsNo = Integer.parseInt(fromGps);
        if (fromGpsNo == 1) {
            scndinfotitle.setVisibility(View.VISIBLE);
            secondinfo.setVisibility(View.VISIBLE);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();   //Closes activity on button DONE
                }
            });
        } else {
            done.setText("PARĀDĪT KARTĒ");
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    ArrayList<com.google.maps.model.LatLng> waypts = null;
                    intent.putExtra("waypts", waypts);
                    intent.putExtra("latLngEnd", objLatLng);
                    Intent intent1 = new Intent("finish_activity");
                    sendBroadcast(intent1);
                    startActivity(intent);
                    finish();
                }
            });
        }
        int activityNo = Integer.parseInt(activityString);
        if (activityNo == 1) {
            secondinfo.setText(R.string.lop1);
            infotext.setText(getString(R.string.lop));        //Sets text
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.lop));   //Sets image
            titletext.setText("LIVONIJAS ORDEŅA PILS");     //Sets title
            objLatLng = "57.396120, 21.559253";
            telephone="63622031";
        }
        if (activityNo == 2) {
            infotext.setText(getString(R.string.rl));
            secondinfo.setText(R.string.rl1);
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.rl));
            titletext.setText("RĀTSLAUKUMS");
            objLatLng = "57.395770, 21.567473";

        }
        if (activityNo == 4) {
            infotext.setText(getString(R.string.strkv));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.strkv));
            titletext.setText("STRŪKLAKA „KUĢU VĒROTĀJS”");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.397867, 21.564248";

        }
        if (activityNo == 5) {
            infotext.setText(getString(R.string.tulkmaja));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.tulkmaja));
            secondinfo.setVisibility(View.GONE);
            titletext.setText("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.395945, 21.566950";
            telephone="63623595";
        }
        if (activityNo == 6) {
            infotext.setText(getString(R.string.gb));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.gb));
            titletext.setText("VENTSPILS GALVENĀ BIBLIOTĒKA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396338, 21.566739";
            telephone="63623598";
        }
        if (activityNo == 7) {
            infotext.setText(getString(R.string.bp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.bt));
            fromGpsNo = 2;
            titletext.setText("VENTSPILS BRĪVOSTAS PĀRVALDE");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396530, 21.560201";
            telephone="63622586";
        }
        if (activityNo == 8) {
            infotext.setText(getString(R.string.jak));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jav));
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            fromGpsNo = 2;
            titletext.setText("JŪRAKMENS");
            objLatLng = "57.398503, 21.568876";
        }
        if (activityNo == 9) {
            infotext.setText(getString(R.string.kvp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kvp));
            titletext.setText("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396985, 21.560243";
        }
        if (activityNo == 10) {
            infotext.setText(getString(R.string.vt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.vt));
            secondinfo.setText(R.string.vt1);
            titletext.setText("VENTSPILS TIRGUS");
            objLatLng = "57.397106, 21.568135";

        }
        if (activityNo == 11) {
            infotext.setText(getString(R.string.am));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.am));
            secondinfo.setText(R.string.am1);
            titletext.setText("AMATU MĀJA");
            objLatLng = "57.397534, 21.566263";
            telephone="63620174";
        }
        if (activityNo == 12) {
            infotext.setText(getString(R.string.pt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.pt));
            titletext.setText("PRĀMJU TERMINĀLIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.398361, 21.569650";
            telephone="26357847";
        }
        if (activityNo == 13) {
            infotext.setText(getString(R.string.dc));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dc));
            titletext.setText("VENTSPILS DIGITĀLAIS CENTRS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396078, 21.566493";
            telephone="63607607";
        }
        if (activityNo == 14) {
            infotext.setText(getString(R.string.jn));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jn));
            secondinfo.setText(R.string.jn1);
            titletext.setText("VENTSPILS JAUNRADES NAMS");
            objLatLng = "57.395365, 21.563156";
            telephone="63622805";

        }
        if (activityNo == 15) {
            infotext.setText(getString(R.string.kk));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kk));
            titletext.setText("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.394795, 21.551473";
        }
        if (activityNo == 16) {
            infotext.setText(getString(R.string.svnik));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.svnik));
            titletext.setText("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.398447, 21.572733";
        }
        if (activityNo == 17) {
            infotext.setText(getString(R.string.jf));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jf));
            titletext.setText("PIEMINEKLIS JĀNIM FABRICIUSAM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396350, 21.566161";
        }
        if (activityNo == 18) {
            infotext.setText(getString(R.string.kupfer));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kupfer));
            titletext.setText("KUPFERNAMS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.393944, 21.563573";
            telephone="63626999";
        }
        if (activityNo == 19) {
            infotext.setText(getString(R.string.klosteris));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.klosteris));
            titletext.setText("KLOSTERIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.395355, 21.557619";
            telephone="29467889";
        }
        if (activityNo == 20) {
            infotext.setText(getString(R.string.mazais));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.mazais));
            titletext.setText("MAZAIS NAMIŅŠ");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.393611, 21.544619";
            telephone="29677730";
        }
        if (activityNo == 21) {
            infotext.setText(getString(R.string.oranžnams));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.oranznams));
            secondinfo.setText(R.string.oranžnams1);
            titletext.setText("ORANŽAIS NAMS");
            objLatLng = "57.391978, 21.544134";
            telephone="29119473";
        }
        if (activityNo == 22) {
            infotext.setText(getString(R.string.portoss));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.portoss));
            titletext.setText("PORTOSS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.389321, 21.542962";
            telephone="26103210";
        }
        if (activityNo == 23) {
            infotext.setText(getString(R.string.dzintari));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dzintari));
            titletext.setText("DZINTARI");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.390291, 21.556095";
            telephone="29736387";
        }
        //food
        if (activityNo == 24) {
            infotext.setText(getString(R.string.landora));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.landora));
            titletext.setText("LANDORA 6");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.394999, 21.565962";
            telephone="29230635";
        }
        if (activityNo == 25) {
            infotext.setText(getString(R.string.erm));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.erm));
            titletext.setText("ĒRMANĪTIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.392392, 21.559977";
            telephone="29264748";
        }
        if (activityNo == 26) {
            infotext.setText(getString(R.string.skroderkrogs));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.skroderkrogs));
            titletext.setText("SKRODERKROGS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.395302, 21.564229";
            telephone="26951552";
        }
        if (activityNo == 27) {
            infotext.setText(getString(R.string.dolcevita));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dolcevita));
            titletext.setText("DOLCE VITA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.394781, 21.567159";
            telephone="63600810";
        }
        if (activityNo == 28) {
            infotext.setText(getString(R.string.burgerbars));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.burgerbars));
            titletext.setText("BURGERBĀRS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396416, 21.565055";
            telephone="29650098";
        }
        if (activityNo == 29) {
            infotext.setText(getString(R.string.ostas23));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.ostas23));
            titletext.setText("OSTAS 23");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
            objLatLng = "57.396636, 21.5606473";
            telephone="22015754";
        }
            if (activityNo == 30) {
                infotext.setText(getString(R.string.niklutbaz));
                infoImage.setImageDrawable(getResources().getDrawable(R.drawable.niklutbaz));
                titletext.setText("VENTSPILS NIKOLAJA LUTERĀŅU BAZNĪCA");
                scndinfotitle.setVisibility(View.GONE);
                secondinfo.setVisibility(View.GONE);
                objLatLng = "57.396002, 21.567951";
            }
        if(activityNo==31){
            titletext.setText("RĀTSGALDS");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.rgalds));        //Sets MAIN text
            //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.rgalds));   //Sets image
            objLatLng="57.395592, 21.567232";
        }
        if(activityNo==32){
            titletext.setText("VENTSPILS LUTERĀŅU DRAUDZES NAMS");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.lutdrnams));        //Sets MAIN text
                   //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.lutdrnams));   //Sets image
            objLatLng="57.396335, 21.567627";
        }
        if(activityNo==33){
            titletext.setText("VENTSPILS ALUS DARĪTAVA “COURLANDER”");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.courlander));        //Sets MAIN text
            secondinfo.setText(R.string.courlander1);
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.courlander));//Sets PAPILDUS INFO TEXT(if it exists)
                           //Hides PAPILDUS INFO(if it doesn’t exist)infoImage.setImageDrawable(getResources().getDrawable(R.drawable.Img.ind));   //Sets image
            objLatLng="57.397319, 21.567090";
        }
        if(activityNo==34){
            titletext.setText("AKA VENTSPILS TIRGUS LAUKUMĀ");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.aka));        //Sets MAIN text
            //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.aka));   //Sets image
            objLatLng="57.397647, 21.567370";
        }
        if(activityNo==35){
            titletext.setText("ZVANU TORNIS TIRGUS LAUKUMĀ");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.zvantornis));        //Sets MAIN text
            //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.zvantornis));   //Sets image
            objLatLng="57.397483, 21.568149";
        }
        if(activityNo==36){
            titletext.setText("GOVIS “PIE SPOGUĻA”");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.piespog));        //Sets MAIN text
            //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.piespog));   //Sets image
            objLatLng="57.398190, 21.569543";
        }
        if(activityNo==37){
            titletext.setText("MĀRĪTES");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.marites));        //Sets MAIN text
            //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.marites));   //Sets image
            objLatLng="57.398470, 21.568062";
        }
        if(activityNo==38){
            titletext.setText("SIEVIŠĶĪGĀ GOVS");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.sievgovs));        //Sets MAIN text
                  //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.sievgovs));   //Sets image
            objLatLng="57.398602, 21.567294";
        }
        if(activityNo==39){
            titletext.setText("GOTIŅA ŠŪPOLĒS");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.supgovs));        //Sets MAIN text
                   //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.supgovs));   //Sets image
            objLatLng="57.398143, 21.565802";
        }
        if(activityNo==40){
            titletext.setText("LATVIJAS MELNĀ");     //Sets title of the ACTIVITY
            infotext.setText(getString(R.string.latvmeln));        //Sets MAIN text
                   //Sets PAPILDUS INFO TEXT(if it exists)
            scndinfotitle.setVisibility(View.GONE);              //Hides PAPILDUS INFO(if it doesn’t exist)
            secondinfo.setVisibility(View.GONE);                //Hides PAPILDUS INFO(if it doesn’t exist)
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.latvmeln));   //Sets image
            objLatLng="57.398184, 21.565340";
        }

        if (telephone != null) {


            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    // Send phone number to intent as data
                    intent.setData(Uri.parse("tel:" + telephone));
                    // Start the dialer app activity with number
                    startActivity(intent);
                }
            });
        }else {
            phone.setVisibility(View.GONE);
        }
    }
}
