package com.example.uservalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String s =getIntent().getStringExtra("name");

        tv = findViewById(R.id.disp);
        tv.setText("Welcome "+s);

    }
}