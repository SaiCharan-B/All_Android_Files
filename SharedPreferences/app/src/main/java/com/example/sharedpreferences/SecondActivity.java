package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        preferences = getSharedPreferences("filename",MODE_PRIVATE);
        String username = preferences.getString("uname","No Data");
        String password = preferences.getString("pass","No Data");

        Toast.makeText(this, username+"\n"+password, Toast.LENGTH_LONG).show();

    }
}