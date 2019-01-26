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

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private Context mContext;

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
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "1");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="AMATU MĀJA") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "11");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="RĀTSLAUKUMS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "2");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="STARPTAUTISKĀ RAKSTNIEKU UN TULKOTĀJU MĀJA") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "5");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="STRŪKLAKA 'KUĢU VĒROTĀJS'") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "4");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS SV. NIKOLAJA PAREIZTICĪGO BAZNĪCA") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "16");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS TIRGUS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "10");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS GALVENĀ BIBLIOTĒKA") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "6");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS BRĪVOSTAS PĀRVALDE") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "7");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="PRĀMJU TERMINĀLIS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "12");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS DIGITĀLAIS CENTRS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "13");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="VENTSPILS JAUNRADES NAMS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "14");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="JŪRAKMENS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "8");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="PIEMINEKLIS KRIŠJĀNIM VALDEMĀRAM") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "9");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="PIEMINEKLIS JŪRNIEKIEM UN ZVEJNIEKIEM") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "15");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="PIEMINEKLIS JĀNIM FABRICIUSAM") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "17");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="LANDORA 6") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "24");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="ĒRMANĪTIS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "25");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="SKRODERKROGS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "26");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="DOLCE VITA") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "27");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="BURGERBĀRS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "28");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="OSTAS 23") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "29");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="KUPFERNAMS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "18");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="KLOSTERIS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "19");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="MAZAIS NAMIŅŠ") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "20");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="ORANŽAIS NAMS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "21");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="PORTOSS") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "22");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
                if(img_pressed=="DZINTARI") {
                    Intent myIntent = new Intent(mContext, InfoActivities.class);
                    Bundle extras = new Bundle();
                    extras.putString("integers", "23");
                    extras.putString("booleanGps", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    myIntent.putExtras(extras);
                    mContext.startActivity(myIntent);
                }
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
