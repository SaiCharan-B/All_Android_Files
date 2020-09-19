package com.example.uservalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText etu,etp,ete,etph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etu = findViewById(R.id.usname);
        etp = findViewById(R.id.pwd);
        ete = findViewById(R.id.eid);
        etph = findViewById(R.id.phno);


    }

    public void sub(View view)
    {
        String uname = etu.getText().toString();
        String pass = etp.getText().toString();
        String email = ete.getText().toString();
        String phnum = etph.getText().toString();

        if(uname.isEmpty() || pass.isEmpty() || email.isEmpty() || phnum.isEmpty())
        {
            Toast.makeText(SignUp.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(SignUp.this,MainActivity.class);
            startActivity(i);
        }
    }
}