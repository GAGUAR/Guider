package com.guider.guider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivities extends AppCompatActivity{
    private TextView infotext;
    private ImageView infoImage;

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
        Button done=(Button)findViewById(R.id.donebtn);
        TextView titletext=(TextView)findViewById(R.id.titletext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   //Closes activity on button DONE
            }
        });
        infotext=(TextView)findViewById(R.id.infotext);
        infoImage=(ImageView)findViewById(R.id.infoimage);

        Intent myIntent = getIntent(); // gets the previously created intent
        String activityString = myIntent.getStringExtra("integers"); // will return "activity integer from GPS_Service"
        int activityNo = Integer.parseInt(activityString);
        if(activityNo==1){
            infotext.setText(getString(R.string.lop));        //Sets text
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.lop));   //Sets image
            titletext.setText("LIVONIJAS ORDEŅA PILS");     //Sets title
        }
        if(activityNo==2){
        infotext.setText(getString(R.string.rl));
        infoImage.setImageDrawable(getResources().getDrawable(R.drawable.rl));
            titletext.setText("RĀTSLAUKUMS");
        }
        if(activityNo==4){
            infotext.setText(getString(R.string.strkv));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.strkv));
            titletext.setText("STRŪKLAKA „KUĢU VĒROTĀJS”");
        }
        if(activityNo==5){
            infotext.setText(getString(R.string.tulkmaja));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.tulkmaja));
            titletext.setText("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA");
        }
        if(activityNo==6){
            infotext.setText(getString(R.string.gb));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.gb));
            titletext.setText("VENTSPILS GALVENĀ BIBLIOTĒKA");
        }
        if(activityNo==7){
            infotext.setText(getString(R.string.bp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.bt));
            titletext.setText("VENTSPILS BRĪVOSTAS PĀRVALDE");
        }
        if(activityNo==8){
            infotext.setText(getString(R.string.jak));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jav));
            titletext.setText("JŪRAKMENS");
        }
        if(activityNo==9){
            infotext.setText(getString(R.string.kvp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kvp));
            titletext.setText("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM");
        }
        if(activityNo==10){
            infotext.setText(getString(R.string.vt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.vt));
            titletext.setText("VENTSPILS TIRGUS");
        }
        if(activityNo==11){
            infotext.setText(getString(R.string.am));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.am));
            titletext.setText("AMATU MĀJA");
        }
        if(activityNo==12){
            infotext.setText(getString(R.string.pt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.pt));
            titletext.setText("PRĀMJU TERMINĀLIS");
        }
        if(activityNo==13){
            infotext.setText(getString(R.string.dc));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dc));
            titletext.setText("VENTSPILS DIGITĀLAIS CENTRS");
        }
        if(activityNo==14){
            infotext.setText(getString(R.string.jn));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jn));
            titletext.setText("VENTSPILS JAUNRADES NAMS");
        }
        if(activityNo==15){
            infotext.setText(getString(R.string.kk));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kk));
            titletext.setText("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM");
        }
        if(activityNo==16){
            infotext.setText(getString(R.string.svnik));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.svnik));
            titletext.setText("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA");
        }
        if(activityNo==17){
            infotext.setText(getString(R.string.jf));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jf));
            titletext.setText("PIEMINEKLIS JĀNIM FABRICIUSAM");
        }
        if(activityNo==18){
            infotext.setText(getString(R.string.kupfer));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kupfer));
            titletext.setText("KUPFERNAMS");
        }
        if(activityNo==19){
            infotext.setText(getString(R.string.klosteris));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.klosteris));
            titletext.setText("KLOSTERIS");
        }
        if(activityNo==20){
            infotext.setText(getString(R.string.mazais));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.mazais));
            titletext.setText("MAZAIS NAMIŅŠ");
        }
        if(activityNo==21){
            infotext.setText(getString(R.string.oranžnams));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.oranznams));
            titletext.setText("ORANŽAIS NAMS");
        }
        if(activityNo==22){
            infotext.setText(getString(R.string.portoss));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.portoss));
            titletext.setText("PORTOSS");
        }
        if(activityNo==23){
            infotext.setText(getString(R.string.dzintari));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dzintari));
            titletext.setText("DZINTARI");
        }
        //food
        if(activityNo==24){
            infotext.setText(getString(R.string.landora));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.landora));
            titletext.setText("LANDORA 6");
        }
        if(activityNo==25){
            infotext.setText(getString(R.string.erm));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.erm));
            titletext.setText("ĒRMANĪTIS");
        }
        if(activityNo==26){
            infotext.setText(getString(R.string.skroderkrogs));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.skroderkrogs));
            titletext.setText("SKRODERKROGS");
        }
        if(activityNo==27){
            infotext.setText(getString(R.string.dolcevita));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dolcevita));
            titletext.setText("DOLCE VITA");
        }
        if(activityNo==28){
            infotext.setText(getString(R.string.burgerbars));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.burgerbars));
            titletext.setText("BURGERBĀRS");
        }
        if(activityNo==29){
            infotext.setText(getString(R.string.ostas23));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.ostas23));
            titletext.setText("OSTAS 23");
        }

    }


}
