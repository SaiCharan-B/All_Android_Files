package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etu,etp;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etu = findViewById(R.id.username);
        etp = findViewById(R.id.password);
        preferences = getSharedPreferences("filename",MODE_PRIVATE);
        if(preferences!=null)
        {
            String user = preferences.getString("uname","Data not Found");
            String pass = preferences.getString("pass","Data not Found");
            etu.setText(user);
            etp.setText(pass);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        String u = etu.getText().toString();
        String p  = etp.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("uname",u);
        editor.putString("pass",p);
        editor.apply();

    }

    public void Next(View view) {
        Intent i =  new Intent(MainActivity.this,SecondActivity.class);
        startActivity(i);

    }
}