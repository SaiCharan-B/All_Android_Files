package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.countInc);
        tv = findViewById(R.id.textcount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                tv.setText(""+c);
            }
        });
        if(savedInstanceState!=null)
        {
            String s = savedInstanceState.getString("var");
            tv.setText(s);
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("var",tv.getText().toString());
    }

    public void display(View view)
    {
        Toast.makeText(this,"Welcome to my APP",Toast.LENGTH_SHORT).show();
    }
}