package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int thour,tmin;
    String m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void timePicker(View view)
    {
        Calendar c = Calendar.getInstance();
        thour = c.get(Calendar.HOUR_OF_DAY);
        tmin  = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                if(i>12)
                {
                    i = i-12;
                    m = "PM";
                    Toast.makeText(MainActivity.this, i+":"+i1+" "+m, Toast.LENGTH_LONG).show();
                }
                else
                {
                    m = "AM";
                    Toast.makeText(MainActivity.this, i+":"+i1+" "+m, Toast.LENGTH_LONG).show();
                }
            }
        },thour,tmin,false);

        timePickerDialog.show();
    }
}