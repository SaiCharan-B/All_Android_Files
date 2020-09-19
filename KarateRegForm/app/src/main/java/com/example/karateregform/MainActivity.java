package com.example.karateregform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(MainActivity.this,R.array.forms,android.R.layout.simple_spinner_item);
        sp.setAdapter(adap);
    }
}