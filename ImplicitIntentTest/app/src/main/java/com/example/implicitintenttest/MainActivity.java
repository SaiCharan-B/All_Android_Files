package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openURL(View view)
    {
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void call(View view)
    {
        Uri u = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void myLocation(View view)
    {
        //this is to zoom
       // Uri mapsuri = Uri.parse("geo:16.4649° N, 80.5078° E?z=21");
        //this is for finding restaurants nearby srm
       // Uri mapsuri = Uri.parse("geo:16.4649° N, 80.5078° E?q=restaurants");
        //this is for adding marker
        //Uri mapsuri = Uri.parse("geo:16.4649° N, 80.5078° E?q=<16.4649° N>,<80.5078° E>");
        Uri mapsuri = Uri.parse("geo:0,0?q=restaurants");
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW,mapsuri);
       // mapsIntent.setPackage("com.google.android.apps.maps");
       // if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
      //  }
    }
}