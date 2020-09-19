package com.example.icebodaawotesting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class InsertActivity extends AppCompatActivity {

    EditText medname;
    NumberPicker dosage;
    RadioButton beforerad,afterrad;
    CheckBox mon,tue,wed,thu,fri,sat,sun,mrng,aftn,nyt;
    String befaf = "After Food",m,tu,w,th,f,sa,su;
    ImageButton tpm,tpa,tpn;
    int hour,min,uhm,umm,uha,uma,uhn,umn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        medname = findViewById(R.id.mednameadd);
        dosage = findViewById(R.id.dosageadd);
        beforerad = findViewById(R.id.before);
        afterrad = findViewById(R.id.after);
        mon = findViewById(R.id.monday);
        tue = findViewById(R.id.tuesday);
        wed = findViewById(R.id.wednesday);
        thu = findViewById(R.id.thursday);
        fri = findViewById(R.id.friday);
        sat = findViewById(R.id.saturday);
        sun = findViewById(R.id.sunday);
        tpm = findViewById(R.id.timemorning);
        tpa = findViewById(R.id.timeafternoon);
        tpn = findViewById(R.id.timenight);

        dosage.setMaxValue(10);
        dosage.setMinValue(1);

        tpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                hour=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                TimePickerDialog td=new TimePickerDialog(InsertActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        uhm=i;
                        umm=i1;
                        Toast.makeText(InsertActivity.this,uhm+":"+umm,Toast.LENGTH_SHORT).show();


                    }
                },hour,min,false);
                td.show();

            }

        });

        tpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                hour=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                TimePickerDialog td=new TimePickerDialog(InsertActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        uha=i;
                        uma=i1;
                        Toast.makeText(InsertActivity.this,uha+":"+uma,Toast.LENGTH_SHORT).show();


                    }
                },hour,min,false);
                td.show();

            }

        });

        tpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                hour=c.get(Calendar.HOUR_OF_DAY);
                min=c.get(Calendar.MINUTE);
                TimePickerDialog td=new TimePickerDialog(InsertActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        uhn=i;
                        umn=i1;
                        Toast.makeText(InsertActivity.this,uhn+":"+umn,Toast.LENGTH_SHORT).show();


                    }
                },hour,min,false);
                td.show();

            }

        });


        mrng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tpm.setVisibility(View.VISIBLE);
                } else {
                    tpm.setVisibility(View.GONE);
                }
            }
        });
        aftn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tpa.setVisibility(View.VISIBLE);
                } else {
                    tpa.setVisibility(View.GONE);
                }
            }
        });
        nyt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tpn.setVisibility(View.VISIBLE);
                } else {
                    tpn.setVisibility(View.GONE);
                }
            }
        });
        /*if(mrng.isChecked())
        {
            tpm.setVisibility(true);
        }*/
    }




    public void save(View view) {
        String mname = medname.getText().toString();
        String dos = String.valueOf(dosage.getValue());
        if(beforerad.isChecked())
        {
            befaf = "Before Food";
        }
        else if(afterrad.isChecked())
        {
            befaf = "After Food";
        }
        if(mon.isChecked())
        {
            if(mrng.isChecked())
            {
                Intent i = new Intent(InsertActivity.this,AlarmReceiver.class);
                i.putExtra("tabname",mname);
                PendingIntent pintent = PendingIntent.getBroadcast( this, 0, i, 0 );

                AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                Calendar timeOff = Calendar.getInstance();
                int days = Calendar.MONDAY + (7 - timeOff.get(Calendar.DAY_OF_WEEK));
                timeOff.add(Calendar.DATE, days);
                timeOff.set(Calendar.HOUR, 12);
                timeOff.set(Calendar.MINUTE, 0);
                timeOff.set(Calendar.SECOND, 0);

                alarm.set(AlarmManager.RTC_WAKEUP, timeOff.getTimeInMillis(), pintent);
            }
        }

        Student student = new Student();
        student.setRollNumber(roll);
        student.setName(nam);
        student.setMailID(mail);
        student.setPhoneNumber(mobile);
        //MainActivity.database.myDAO().insert(student);

        MainActivity.viewModel.insert(student);

        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_LONG).show();

        finish();
    }
}
