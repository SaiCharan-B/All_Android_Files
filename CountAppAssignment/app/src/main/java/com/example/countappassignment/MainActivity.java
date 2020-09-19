package com.example.countappassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int c=0;
    Button res,toas;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.reset);
        toas = findViewById(R.id.toast);
        tv = findViewById(R.id.textv);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=0;
                tv.setText(""+c);
            }
        });

        toas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tv.getText().toString();
                Toast.makeText(MainActivity.this,"The value is "+s,Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState!=null)
        {
            String s = savedInstanceState.getString("var");
            c = Integer.parseInt(s);
            tv.setText(s);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("var",tv.getText().toString());
    }

    public void add(View view)
    {
        c++;
        tv.setText(""+c);
    }

    public void minus(View view)
    {
        c--;
        tv.setText(""+c);
    }
}