package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etn,etr,etph,ete,etp;
    RadioButton rm,rf;
    Spinner spb;
    String Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = findViewById(R.id.name);
        etr = findViewById(R.id.rollno);
        etph = findViewById(R.id.phno);
        ete = findViewById(R.id.email);
        etp = findViewById(R.id.pass);
        rm = findViewById(R.id.radm);
        rf = findViewById(R.id.radf);
        spb = findViewById(R.id.spbranch);

        ArrayAdapter<CharSequence> branadap = ArrayAdapter.createFromResource(MainActivity.this,R.array.Branches,android.R.layout.simple_spinner_item);
        spb.setAdapter(branadap);

    }

    public void submit(View view)
    {
        String name = etn.getText().toString();
        String roll = etr.getText().toString();
        String phn = etph.getText().toString();
        String email = ete.getText().toString();
        String pass = etp.getText().toString();
        if(rm.isChecked())
        {
            Gender = rm.getText().toString();
        }
        else if(rf.isChecked())
        {
            Gender = rf.getText().toString();
        }
        String branch = spb.getSelectedItem().toString();

        if(name.isEmpty() || roll.isEmpty() || phn.isEmpty() || email.isEmpty() || pass.isEmpty() || Gender.isEmpty() || branch.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("nam",name);
            i.putExtra("rollno",roll);
            i.putExtra("phno",phn);
            i.putExtra("email",email);
            i.putExtra("pass",pass);
            i.putExtra("gender",Gender);
            i.putExtra("branch",branch);
            startActivity(i);
        }
    }
}