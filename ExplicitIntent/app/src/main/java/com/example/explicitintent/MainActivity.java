package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.username);
    }

    public void Submit(View view)
    {
        String data = et.getText().toString();
        if(data.isEmpty())
        {
            Toast.makeText(this,"please enter data",Toast.LENGTH_SHORT);
        }
        else
        {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("mydata",data);
            startActivity(i);
        }

    }
}