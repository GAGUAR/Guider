package com.guider.guider;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.guider.guider.Config.Config;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {
    private static final int PAYPAL_REQUEST_CODE = 0404;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);
    String amount = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PAYPAL_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                PaymentConfirmation confirmation = data.getParcelableExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if(confirmation != null){
                try {
                    String paymentDetails = confirmation.toJSONObject().toString(4);
                    startActivity(new Intent(this, PaymentDetails.class)
                    .putExtra("PaymentDetails",paymentDetails)
                            .putExtra("PaymentAmount",amount)

                    );
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }
            else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if(resultCode== com.paypal.android.sdk.payments.PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this, "Invalid",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);
        SystemClock.sleep(3000);
        processPay();
    }

    private void processPay() {
        amount = "2.99";
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),"EUR","Buy Guider Pass",
                PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, com.paypal.android.sdk.payments.PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }
}
