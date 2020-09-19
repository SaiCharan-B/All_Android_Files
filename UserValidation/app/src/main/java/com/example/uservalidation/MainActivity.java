package com.example.uservalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etu,etp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etu = findViewById(R.id.usermain);
        etp = findViewById(R.id.passmain);
    }

    public void Loginmain(View view)
    {
        String uname = etu.getText().toString();
        String pass = etp.getText().toString();
        if(uname.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(MainActivity.this,HomePage.class);
            i.putExtra("name",uname);
            startActivity(i);
        }
    }

    public void Signupmain(View view)
    {
        Intent i = new Intent(MainActivity.this,SignUp.class);
        startActivity(i);
    }
}