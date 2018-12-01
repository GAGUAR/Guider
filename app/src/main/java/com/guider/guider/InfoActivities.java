package com.guider.guider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivities extends AppCompatActivity{
    private TextView infotext;
    private ImageView infoImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activities);
        Button done=(Button)findViewById(R.id.donebtn);
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
            this.setTitle("LIVONIJAS ORDEŅA PILS");     //Sets title
        }
        if(activityNo==2){
        infotext.setText(getString(R.string.rl));
        infoImage.setImageDrawable(getResources().getDrawable(R.drawable.rl));
        this.setTitle("RĀTSLAUKUMS");
        }
        if(activityNo==4){
            infotext.setText(getString(R.string.strkv));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.strkv));
            this.setTitle("STRŪKLAKA „KUĢU VĒROTĀJS”");
        }
        if(activityNo==5){
            infotext.setText(getString(R.string.tulkmaja));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.tulkmaja));
            this.setTitle("STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA");
        }
        if(activityNo==6){
            infotext.setText(getString(R.string.gb));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.gb));
            this.setTitle("VENTSPILS GALVENĀ BIBLIOTĒKA");
        }
        if(activityNo==7){
            infotext.setText(getString(R.string.bp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.bt));
            this.setTitle("VENTSPILS BRĪVOSTAS PĀRVALDE");
        }
        if(activityNo==8){
            infotext.setText(getString(R.string.jak));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jav));
            this.setTitle("JŪRAKMENS");
        }
        if(activityNo==9){
            infotext.setText(getString(R.string.kvp));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kvp));
            this.setTitle("PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM");
        }
        if(activityNo==10){
            infotext.setText(getString(R.string.vt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.vt));
            this.setTitle("VENTSPILS TIRGUS");
        }
        if(activityNo==11){
            infotext.setText(getString(R.string.am));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.am));
            this.setTitle("AMATU MĀJA");
        }
        if(activityNo==12){
            infotext.setText(getString(R.string.pt));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.pt));
            this.setTitle("PRĀMJU TERMINĀLIS");
        }
        if(activityNo==13){
            infotext.setText(getString(R.string.dc));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.dc));
            this.setTitle("VENTSPILS DIGITĀLAIS CENTRS");
        }
        if(activityNo==14){
            infotext.setText(getString(R.string.jn));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jn));
            this.setTitle("VENTSPILS JAUNRADES NAMS");
        }
        if(activityNo==15){
            infotext.setText(getString(R.string.kk));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.kk));
            this.setTitle("PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM");
        }
        if(activityNo==16){
            infotext.setText(getString(R.string.svnik));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.svnik));
            this.setTitle("VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA");
        }
        if(activityNo==17){
            infotext.setText(getString(R.string.jf));
            infoImage.setImageDrawable(getResources().getDrawable(R.drawable.jf));
            this.setTitle("PIEMINEKLIS JĀNIM FABRICIUSAM");
        }
    }

}
