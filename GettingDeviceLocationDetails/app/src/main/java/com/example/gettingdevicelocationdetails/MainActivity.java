package com.example.gettingdevicelocationdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        client = LocationServices.getFusedLocationProviderClient(this);



    }

    public void getLocationDetails(View view) {
       // getDeviceDetails();
        if (ActivityCompat.checkSelfPermission(MainActivity.this,

                Manifest.permission.ACCESS_FINE_LOCATION) ==

                PackageManager.PERMISSION_GRANTED) {

            getDeviceDetails();


        } else {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getDeviceDetails() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        client.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    String latitude = String.valueOf(list.get(0).getLatitude());
                    String longitude = String.valueOf(list.get(0).getLongitude());
                    String countryname = String.valueOf(list.get(0).getCountryName());
                    String locality = String.valueOf(list.get(0).getLocality());
                    String postalcode = String.valueOf(list.get(0).getPostalCode());
                    String addressline = String.valueOf(list.get(0).getAddressLine(0));
                    tv.setText(latitude + "," + longitude + "\n" + countryname + "\n" + locality + "\n" + postalcode + "\n" + addressline);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}