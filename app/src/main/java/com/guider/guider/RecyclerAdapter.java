package com.guider.guider;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames;
    private ArrayList<Integer> mImages;
    private Context mContext;
    private String booleanGps="2";

    public RecyclerAdapter(Context context, ArrayList<String> imageNames, ArrayList<Integer> images ) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                String img_pressed=mImageNames.get(position);
                if(img_pressed=="LIVONIJAS ORDEŅA PILS") {
                    String integer = "1";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="AMATU MĀJA") {
                    String integer = "11";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="RĀTSLAUKUMS") {
                    String integer = "2";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA") {
                    String integer = "5";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="STRŪKLAKA 'KUĢU VĒROTĀJS'") {
                    String integer = "4";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA") {
                    String integer = "16";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS TIRGUS") {
                    String integer = "10";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS GALVENĀ BIBLIOTĒKA") {
                    String integer = "6";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS BRĪVOSTAS PĀRVALDE") {
                    String integer = "7";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="PRĀMJU TERMINĀLIS") {
                    String integer = "12";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS DIGITĀLAIS CENTRS") {
                    String integer = "13";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS JAUNRADES NAMS") {
                    String integer = "14";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="JŪRAKMENS") {
                    String integer = "8";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM") {
                    String integer = "9";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM") {
                    String integer = "15";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="PIEMINEKLIS JĀNIM FABRICIUSAM") {
                    String integer = "17";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="LANDORA 6") {
                    String integer = "24";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="ĒRMANĪTIS") {
                    String integer = "25";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="SKRODERKROGS") {
                    String integer = "26";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="DOLCE VITA") {
                    String integer = "27";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="BURGERBĀRS") {
                    String integer = "28";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="OSTAS 23") {
                    String integer = "29";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="KUPFERNAMS") {
                    String integer = "18";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="KLOSTERIS") {
                    String integer = "19";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="MAZAIS NAMIŅŠ") {
                    String integer = "20";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="ORANŽAIS NAMS") {
                    String integer = "21";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="PORTOSS") {
                    String integer = "22";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="DZINTARI") {
                    String integer = "23";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS NIKOLAJA LUTERĀŅU BAZNĪCA") {
                    String integer = "30";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="RĀTSGALDS") {
                    String integer = "31";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS LUTERĀŅU DRAUDZES NAMS") {
                    String integer = "32";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="VENTSPILS ALUS DARĪTAVA “COURLANDER”") {
                    String integer = "33";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="AKA VENTSPILS TIRGUS LAUKUMĀ") {
                    String integer = "34";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="ZVANU TORNIS TIRGUS LAUKUMĀ") {
                    String integer = "35";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="GOVIS “PIE SPOGUĻA”") {
                    String integer = "36";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="MĀRĪTES") {
                    String integer = "37";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="SIEVIŠĶĪGĀ GOVS") {
                    String integer = "38";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="GOTIŅA ŠŪPOLĒS") {
                    String integer = "39";
                    imagePressed(integer,booleanGps);
                }
                if(img_pressed=="LATVIJAS MELNĀ") {
                    String integer = "40";
                    imagePressed(integer,booleanGps);
                }

            }
            private void imagePressed(String integer, String booleanGps) {
                Intent myIntent = new Intent(mContext, InfoActivities.class);
                Bundle extras = new Bundle();
                extras.putString("integers", integer);
                extras.putString("booleanGps", booleanGps);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myIntent.putExtras(extras);
                mContext.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
