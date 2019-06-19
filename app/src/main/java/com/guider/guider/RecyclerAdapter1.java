package com.guider.guider;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static com.guider.guider.R.string.aps;


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
                Log.d(TAG, " ");

                String img_pressed=mImageNames1.get(position);
                if(img_pressed== mContext1.getString(R.string.aps)) {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "1");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed==mContext1.getString(R.string.piem)) {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "3");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed==mContext1.getString(R.string.hotels)) {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "5");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed==mContext1.getString(R.string.cafe)) {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "4");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed==mContext1.getString(R.string.iestad)) {
                    Intent myIntent = new Intent(mContext1, RecyclerActivity.class);
                    myIntent.putExtra("chosen", "2");
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext1.startActivity(myIntent);
                }
                if(img_pressed==mContext1.getString(R.string.VECPILSĒTA)) {
                    Intent myIntent = new Intent(mContext1, MainActivity.class);
                    ArrayList<LatLng>waypts=new ArrayList<>();
                    waypts.add(new LatLng(57.395557376,21.567588039));
                    waypts.add(new LatLng(57.395668842,21.567509919));
                    waypts.add(new LatLng(57.395762784,21.567465663));
                    waypts.add(new LatLng(57.395898819,21.567477733));
                    waypts.add(new LatLng(57.396027447,21.567489132));
                    waypts.add(new LatLng(57.396087967,21.567485109));
                    waypts.add(new LatLng(57.396319387,21.567492820));
                    waypts.add(new LatLng(57.396636435,21.567508578));
                    waypts.add(new LatLng(57.397181644,21.567354351));
                    waypts.add(new LatLng(57.397460387,21.567247398));
                    waypts.add(new LatLng(57.397799645,21.567118652));
                    waypts.add(new LatLng(57.397898279,21.567704380));
                    waypts.add(new LatLng(57.397986254,21.568229087));
                    waypts.add(new LatLng(57.398057429,21.568259262));
                    waypts.add(new LatLng(57.398110177,21.568302177));
                    waypts.add(new LatLng(57.398143055,21.568379290));
                    waypts.add(new LatLng(57.398188758,21.568557322));
                    waypts.add(new LatLng(57.398248372,21.568787992));
                    waypts.add(new LatLng(57.398358927,21.569273807));
                    waypts.add(new LatLng(57.398453584,21.569293588));
                    waypts.add(new LatLng(57.398582564,21.569210775));
                    waypts.add(new LatLng(57.398647777,21.569012627));
                    waypts.add(new LatLng(57.398684809,21.568727978));
                    waypts.add(new LatLng(57.398698899,21.568352468));
                    waypts.add(new LatLng(57.398690770,21.568109058));
                    waypts.add(new LatLng(57.398661506,21.567897834));
                    waypts.add(new LatLng(57.398590332,21.567544788));
                    waypts.add(new LatLng(57.398540655,21.567359380));
                    waypts.add(new LatLng(57.398184062,21.565707810));
                    waypts.add(new LatLng(57.397878588,21.565852650));
                    waypts.add(new LatLng(57.397606171,21.565977708));
                    waypts.add(new LatLng(57.397413599,21.565045975));
                    waypts.add(new LatLng(57.397765503,21.564624868));
                    waypts.add(new LatLng(57.397599125,21.564127654));
                    waypts.add(new LatLng(57.397533008,21.563873179));
                    waypts.add(new LatLng(57.397458942,21.563542262));
                    waypts.add(new LatLng(57.397406915,21.563197598));
                    waypts.add(new LatLng(57.397368075,21.562952511));
                    waypts.add(new LatLng(57.397454245,21.562716141));
                    waypts.add(new LatLng(57.397472490,21.562546492));
                    waypts.add(new LatLng(57.397460929,21.562395617));
                    waypts.add(new LatLng(57.397426425,21.562239379));
                    waypts.add(new LatLng(57.397365907,21.561957747));
                    waypts.add(new LatLng(57.397147681,21.561123244));
                    waypts.add(new LatLng(57.397002618,21.560584120));
                    waypts.add(new LatLng(57.396894950,21.560207605));
                    waypts.add(new LatLng(57.396695870,21.560375579));
                    waypts.add(new LatLng(57.396498958,21.560481526));
                    waypts.add(new LatLng(57.396301502,21.560603231));
                    waypts.add(new LatLng(57.396122834,21.560725607));
                    waypts.add(new LatLng(57.395861785,21.560864747));
                    waypts.add(new LatLng(57.395949403,21.561302282));
                    waypts.add(new LatLng(57.396021847,21.561670750));
                    waypts.add(new LatLng(57.396085980,21.562057994));
                    waypts.add(new LatLng(57.396141441,21.562499218));
                    waypts.add(new LatLng(57.395653847,21.562472396));
                    waypts.add(new LatLng(57.395720872,21.563368253));
                    waypts.add(new LatLng(57.396172875,21.563178822));
                    waypts.add(new LatLng(57.396312161,21.564693935));
                    waypts.add(new LatLng(57.396417483,21.565729603));
                    waypts.add(new LatLng(57.396332936,21.565862708));
                    waypts.add(new LatLng(57.396296805,21.566013582));
                    waypts.add(new LatLng(57.396274946,21.566131264));
                    waypts.add(new LatLng(57.396225807,21.566380039));
                    waypts.add(new LatLng(57.396183173,21.566631496));
                    waypts.add(new LatLng(57.396149209,21.566862501));
                    waypts.add(new LatLng(57.396112536,21.567137092));
                    myIntent.putExtra("waypts",waypts);
                    String latLngEnd=null;
                    myIntent.putExtra("latLngEnd",latLngEnd);
                    Intent intent1 = new Intent("finish_activity");
                    mContext1.sendBroadcast(intent1);
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
