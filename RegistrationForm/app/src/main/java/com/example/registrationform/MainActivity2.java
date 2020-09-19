package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.details);

        String n = getIntent().getStringExtra("nam");
        String r = getIntent().getStringExtra("rollno");
        String ph = getIntent().getStringExtra("phno");
        String e = getIntent().getStringExtra("email");
        String p = getIntent().getStringExtra("pass");
        String g = getIntent().getStringExtra("gender");
        String b = getIntent().getStringExtra("branch");

        tv.setText("Name : "+n+"\n \n"+"Roll No : "+r+"\n \n"+"Mobile Number : "+ph+"\n \n"+"Email ID :"+e+"\n \n"+"Password : "+p+"\n \n"+"Gender :"+g+"\n \n"+"Branch"+b);

    }
}