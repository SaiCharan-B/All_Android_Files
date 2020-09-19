package com.example.alaramtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch s;
    AlarmManager manager;
    AlaramReceiver receiver;
    public static final String MY_CUSTOM_ACTION = "com.example.alaramtest";
    PendingIntent pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = findViewById(R.id.myswitch);
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        receiver = new AlaramReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MY_CUSTOM_ACTION);
        Intent i = new Intent(MY_CUSTOM_ACTION);
        this.registerReceiver(receiver,filter);
        pi = PendingIntent.getBroadcast(this,22,i,PendingIntent.FLAG_UPDATE_CURRENT);


        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s.isChecked())
                {
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                    long triggertime = SystemClock.elapsedRealtime()+2*60*1000;
                    long intervalTime = 1*60*1000;
                    manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggertime,intervalTime,pi);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                    manager.cancel(pi);
                }
            }
        });
    }
}