package com.example.workmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // we have two types of work requests
    //1. OneTime WorkRequest(One time)
    //2.Periodic WorkRequest(Repeated)

    OneTimeWorkRequest firstReq,secondReq;
    PeriodicWorkRequest periodicWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresCharging(true).build();
      //  firstReq = new OneTimeWorkRequest.Builder(FirstWork.class).build();
        periodicWorkRequest = new PeriodicWorkRequest.Builder(FirstWork.class,15,TimeUnit.MINUTES).build();
        periodicWorkRequest = new PeriodicWorkRequest.Builder(FirstWork.class,15,TimeUnit.MINUTES).build();
      //  secondReq = new OneTimeWorkRequest.Builder(SecondWork.class).setInitialDelay(10, TimeUnit.SECONDS).setConstraints(constraints).build();
        

    }

    public void submit(View view) {

       // WorkManager.getInstance(this).beginWith(secondReq).then(firstReq).enqueue();

        WorkManager.getInstance(this).enqueue(firstReq);
        WorkManager.getInstance(this).enqueue(secondReq);

       // WorkManager.getInstance(this).enqueue(firstReq);

    }
}