package com.example.paymentgateways;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "rzp_test_f2J7y4T3JvgV3U";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkout.preload(getApplicationContext());
    }

    public void paynow(View view)  {

        Checkout checkout = new Checkout();
        checkout.setKeyID(API_KEY);

        Activity activity = this;


        try
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","APSSDC-SRM");
            jsonObject.put("currency","INR");
            jsonObject.put("amount","500");

            checkout.open(activity,jsonObject);
        }
        catch (Exception e)
        {

        }
            }
}