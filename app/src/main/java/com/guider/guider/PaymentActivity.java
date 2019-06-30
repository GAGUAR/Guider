package com.guider.guider;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import org.json.JSONException;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler{
    BillingProcessor bp;
    Button pay;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        bp = new BillingProcessor(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiyI3QkVqWDLTHuoR5VHM/Wjm7FaRZ77yrasjG9jx8EvATvsTXywMEjRGY0xymqPragtc1zx2phPgAOMlZ8vEe4voUDEK6zkGhXhFq4VuFRlKXErwimAhgrHq+A7B+KfoXJFKDw4RVolTp7rCWVPCgsodTg26iMo309PVH0zOpZBz45hxw7qW2H2H/O64NCPEX2vrvf6rhBSrl07+Zzk0Y3dGlkGbvxNMF+nW7LNxnLBd56eFBHWPbMM+37Ryl0d2YSbk3+Hm4S2IgbDEQxtTNPT+vNw0Q665MnS2EZORr24eO+O0oRlk44Zm3utQSZ0WSy9vTzB7czLpjhs8z/JGwQIDAQAB", this);
        pay = findViewById(R.id.paybtn);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.consumePurchase("com.guider.entrance");
                bp.purchase(PaymentActivity.this,"com.guider.entrance");
            }
        });
    }



    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, 6);
        Date plusDate = calendar.getTime();
        String dateTime = dateFormat.format(plusDate);
        FirebaseUser user = mAuth.getCurrentUser();
        String userID = user.getUid();
        myRef.child("users").child(userID).child("endTime").setValue(dateTime);
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        finish();
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }
}