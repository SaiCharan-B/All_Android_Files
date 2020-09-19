package com.example.broadcastrecievertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    IntentFilter filter;
    MyReceiver receiver;

    public static final String MY_CUSTOM_ACTION = "com.example.broadcastrecievertest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
        filter = new IntentFilter();
        // System Broadcast
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //
        this.registerReceiver(receiver,filter);
        // Custom Broadcast
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(receiver,
                        new IntentFilter(MY_CUSTOM_ACTION));
    }

    public void sendCustomBr(View view) {
        Intent i = new Intent(MY_CUSTOM_ACTION);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);

    }
}