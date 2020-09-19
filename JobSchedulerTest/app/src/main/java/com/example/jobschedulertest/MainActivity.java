package com.example.jobschedulertest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void dojob(View view) {
        //charging connected and internet conected
        JobInfo.Builder builder = new JobInfo.Builder(7,new ComponentName(getPackageName(),MyJobService.class.getName()));
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(true);
        scheduler.schedule(builder.build());

    }
}