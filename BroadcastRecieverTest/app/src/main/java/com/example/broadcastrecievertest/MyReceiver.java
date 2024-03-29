package com.example.broadcastrecievertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action){
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power is connected", Toast.LENGTH_SHORT).show();
                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                break;

            case MainActivity.MY_CUSTOM_ACTION:
                Toast.makeText(context, "This is Custom BR", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
