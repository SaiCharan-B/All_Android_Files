package com.example.roomlivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText rollnum,mailid,phonenum,uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        rollnum = findViewById(R.id.rollnum);
        uname = findViewById(R.id.name);
        mailid = findViewById(R.id.mailid);
        phonenum = findViewById(R.id.phnum);

    }

    public void save(View view) {
        String roll = rollnum.getText().toString();
        String nam = uname.getText().toString();
        String mail = mailid.getText().toString();
        String mobile = phonenum.getText().toString();

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