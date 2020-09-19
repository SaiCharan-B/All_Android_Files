package com.example.scorecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tva,tvb;
    int ca=0,cb=0;
    Button ba1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tva = findViewById(R.id.teama);
        tvb = findViewById(R.id.teamb);
        ba1 = findViewById(R.id.a1);

        ba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ca=ca+1;
                tva.setText(""+ca);
            }
        });

        if(savedInstanceState!=null)
        {
            String sa = savedInstanceState.getString("a");
            String sb = savedInstanceState.getString("b");
            tva.setText(sa);
            tvb.setText(sb);
            ca=Integer.parseInt(sa);
            cb=Integer.parseInt(sb);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("a",tva.getText().toString());
        outState.putString("b",tvb.getText().toString());
    }

    public void a3(View view)
    {
        ca=ca+3;
        tva.setText(""+ca);
    }

    public void a2(View view)
    {
        ca=ca+2;
        tva.setText(""+ca);

    }

   /* public void a1(View view)
    {
        ca=ca+1;
        tva.setText(""+ca);
    } */

    public void b3(View view)
    {
        cb=cb+3;
        tvb.setText(""+cb);
    }

    public void b2(View view)
    {
        cb=cb+2;
        tvb.setText(""+cb);
    }

    public void b1(View view)
    {
        cb=cb+1;
        tvb.setText(""+cb);
    }

    public void reset(View view)
    {
        ca=0;
        cb=0;
        tva.setText(""+ca);
        tvb.setText(""+cb);
    }
}