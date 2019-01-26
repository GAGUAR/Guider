package com.guider.guider;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames1 = new ArrayList<>();
    private ArrayList<Integer> mImages1 = new ArrayList<>();
    private Context mContext1;

    public RecyclerAdapter1(Context context1, ArrayList<String> imageNames1, ArrayList<Integer> images1 ) {
        mImageNames1 = imageNames1;
        mImages1 = images1;
        mContext1 = context1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem1, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext1)
                .asBitmap()
                .load(mImages1.get(position))
                .into(holder.image1);

        holder.imageName1.setText(mImageNames1.get(position));

        holder.parentLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames1.get(position));

                String img_pressed=mImageNames1.get(position);
                if(img_pressed=="APSKATES OBJEKTI") {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "1");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed=="PIEMINEKĻI") {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "3");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed=="VIESNĪCAS") {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "5");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed=="RESTORĀNI UN KAFEJNĪCAS") {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "4");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed=="IESTĀDES") {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames1.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image1;
        TextView imageName1;
        RelativeLayout parentLayout1;

        public ViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            imageName1 = itemView.findViewById(R.id.image_name1);
            parentLayout1 = itemView.findViewById(R.id.parent_layout1);
        }
    }
}
