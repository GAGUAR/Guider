package com.guider.guider;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PaymentDetails extends AppCompatActivity {
    TextView txtId, txtAmount, txtStatus;
    Button ok;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        ok = findViewById(R.id.btnok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentDetails.this, HomeActivity.class));
                finish();
            }
        });
        txtId = findViewById(R.id.txtId);
        txtAmount = findViewById(R.id.txtAmount);
        txtStatus = findViewById(R.id.txtStatus);
        Intent intent =getIntent();
        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtId.setText("Payment ID: "+response.getString("id"));
            String status = response.getString("state");
            txtStatus.setText("Status: "+status);
            txtAmount.setText("Amount: "+paymentAmount + " EUR");
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



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
