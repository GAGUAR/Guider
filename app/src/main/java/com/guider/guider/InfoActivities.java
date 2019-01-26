package com.guider.guider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivities extends AppCompatActivity{
    private TextView infotext;
    private ImageView infoImage;
    private static final String TAG="MyLogs";
    private int fromGpsNo;

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
        TextView secondinfo=(TextView)findViewById(R.id.infotext2);
        TextView scndinfotitle=(TextView)findViewById(R.id.secondinfo);
        scndinfotitle.setVisibility(View.GONE);
        secondinfo.setVisibility(View.GONE);
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

        Bundle extras = getIntent().getExtras();
        String activityString = extras.getString("integers");
        String fromGps = extras.getString("booleanGps");
        fromGpsNo=Integer.parseInt(fromGps);
        if(fromGpsNo==1){
            scndinfotitle.setVisibility(View.VISIBLE);
            secondinfo.setVisibility(View.VISIBLE);
        }
        int activityNo = Integer.parseInt(activityString);
        if(activityNo==1){
            secondinfo.setText(R.string.lop1);
            infotext.setText(getString(R.string.lop));        //Sets text
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.lop));   //Sets image
            titletext.setText("LIVONIJAS ORDEŅA PILS");     //Sets title

        }
        if(activityNo==2){
        infotext.setText(getString(R.string.rl));
        secondinfo.setText(R.string.rl1);
        infoImage.setImageDrawable(getResources().getDrawable(R.drawable.rl));
            titletext.setText("RĀTSLAUKUMS");

        }
        if(activityNo==4){
            infotext.setText(getString(R.string.strkv));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.strkv));
            titletext.setText("STRŪKLAKA „KUĢU VĒROTĀJS”");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);

        }
        if(activityNo==5){
            infotext.setText(getString(R.string.tulkmaja));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.tulkmaja));
            secondinfo.setVisibility(View.GONE);
            titletext.setText("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==6){
            infotext.setText(getString(R.string.gb));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.gb));
            titletext.setText("VENTSPILS GALVENĀ BIBLIOTĒKA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==7){
            infotext.setText(getString(R.string.bp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.bt));
            fromGpsNo=2;
            titletext.setText("VENTSPILS BRĪVOSTAS PĀRVALDE");
        }
        if(activityNo==8){
            infotext.setText(getString(R.string.jak));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jav));
            fromGpsNo=2;
            titletext.setText("JŪRAKMENS");
        }
        if(activityNo==9){
            infotext.setText(getString(R.string.kvp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kvp));
            titletext.setText("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==10){
            infotext.setText(getString(R.string.vt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.vt));
            secondinfo.setText(R.string.vt1);
            titletext.setText("VENTSPILS TIRGUS");

        }
        if(activityNo==11){
            infotext.setText(getString(R.string.am));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.am));
            secondinfo.setText(R.string.am1);
            titletext.setText("AMATU MĀJA");

        }
        if(activityNo==12){
            infotext.setText(getString(R.string.pt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.pt));
            titletext.setText("PRĀMJU TERMINĀLIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==13){
            infotext.setText(getString(R.string.dc));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dc));
            titletext.setText("VENTSPILS DIGITĀLAIS CENTRS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==14){
            infotext.setText(getString(R.string.jn));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jn));
            secondinfo.setText(R.string.jn1);
            titletext.setText("VENTSPILS JAUNRADES NAMS");

        }
        if(activityNo==15){
            infotext.setText(getString(R.string.kk));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kk));
            titletext.setText("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==16){
            infotext.setText(getString(R.string.svnik));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.svnik));
            titletext.setText("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==17){
            infotext.setText(getString(R.string.jf));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jf));
            titletext.setText("PIEMINEKLIS JĀNIM FABRICIUSAM");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==18){
            infotext.setText(getString(R.string.kupfer));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kupfer));
            titletext.setText("KUPFERNAMS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==19){
            infotext.setText(getString(R.string.klosteris));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.klosteris));
            titletext.setText("KLOSTERIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==20){
            infotext.setText(getString(R.string.mazais));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.mazais));
            titletext.setText("MAZAIS NAMIŅŠ");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==21){
            infotext.setText(getString(R.string.oranžnams));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.oranznams));
            secondinfo.setText(R.string.oranžnams1);
            titletext.setText("ORANŽAIS NAMS");
        }
        if(activityNo==22){
            infotext.setText(getString(R.string.portoss));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.portoss));
            titletext.setText("PORTOSS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==23){
            infotext.setText(getString(R.string.dzintari));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dzintari));
            titletext.setText("DZINTARI");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        //food
        if(activityNo==24){
            infotext.setText(getString(R.string.landora));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.landora));
            titletext.setText("LANDORA 6");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==25){
            infotext.setText(getString(R.string.erm));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.erm));
            titletext.setText("ĒRMANĪTIS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==26){
            infotext.setText(getString(R.string.skroderkrogs));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.skroderkrogs));
            titletext.setText("SKRODERKROGS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==27){
            infotext.setText(getString(R.string.dolcevita));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dolcevita));
            titletext.setText("DOLCE VITA");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==28){
            infotext.setText(getString(R.string.burgerbars));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.burgerbars));
            titletext.setText("BURGERBĀRS");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }
        if(activityNo==29){
            infotext.setText(getString(R.string.ostas23));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.ostas23));
            titletext.setText("OSTAS 23");
            scndinfotitle.setVisibility(View.GONE);
            secondinfo.setVisibility(View.GONE);
        }

    }


}
