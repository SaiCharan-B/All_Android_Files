package com.example.inputcontrolstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etn,etm,ete,etp;
    TextView tv;
    RadioButton rm,rf;
    CheckBox cbj,cba,cbp;
    String gender;
    Spinner spd,spm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = findViewById(R.id.name);
        etm = findViewById(R.id.mobile);
        ete = findViewById(R.id.email);
        etp = findViewById(R.id.pass);
        rm = findViewById(R.id.male);
        cbj = findViewById(R.id.java);
        cba = findViewById(R.id.android);
        cbp = findViewById(R.id.python);
        rf = findViewById(R.id.female);
        spd = findViewById(R.id.dist);
        spm = findViewById(R.id.mandal);
        tv = findViewById(R.id.result);

        ArrayAdapter<CharSequence> distAdap = ArrayAdapter.createFromResource(this,R.array.dist,android.R.layout.simple_spinner_item);
        spd.setAdapter(distAdap);

        spd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        Toast.makeText(MainActivity.this, "Please Select a District", Toast.LENGTH_SHORT).show();

                    case 1:
                        ArrayAdapter<CharSequence> atpm = ArrayAdapter.createFromResource(MainActivity.this,R.array.Anantapur_mandal,android.R.layout.simple_spinner_item);
                        spm.setAdapter(atpm);
                        break;

                    case 2:
                        ArrayAdapter<CharSequence> knlm = ArrayAdapter.createFromResource(MainActivity.this,R.array.Kurnool_mandal,android.R.layout.simple_spinner_item);
                        spm.setAdapter(knlm);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void submit(View view)
    {
        String name = etn.getText().toString();
        String mob = etm.getText().toString();
        String email = ete.getText().toString();
        String pass = etp.getText().toString();
        if(rm.isChecked())
        {
            gender = rm.getText().toString();
        }
        else if(rf.isChecked())
        {
            gender = rf.getText().toString();
        }
        StringBuilder builder = new StringBuilder();
        if(cbj.isChecked())
        {
            builder.append(cbj.getText().toString());
        }
        if(cba.isChecked())
        {
            builder.append(cba.getText().toString());
        }
        if(cbp.isChecked())
        {
            builder.append(cbp.getText().toString());
        }
        String selectedDist = spd.getSelectedItem().toString();
        String selectedMandal = spm.getSelectedItem().toString();
        tv.setText(name+"\n"+mob+"\n"+email+"\n"+pass+"\n"+gender+"\n"+builder+"\n"+selectedDist+"\n"+selectedMandal);
    }
}