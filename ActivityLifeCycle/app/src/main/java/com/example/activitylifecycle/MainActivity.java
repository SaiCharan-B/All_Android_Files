package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textstate);
        tv.append("onCreate() \n");
        String s = savedInstanceState.getString("state");
        tv.setText(s);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.append("onStart() \n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.append("onResume() \n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv.append("onRestart() \n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.append("onDestroy()");
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.append("onPause() \n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.append("onStop() \n");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("state",tv.getText().toString());
    }
}