package com.example.roomlivedatabaseformassn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText uname,mailid,phone,address;
    Spinner depart;
    RadioButton male,female;
    CheckBox eng,tel,hin;
    String Gender;
    StringBuilder langs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        uname = findViewById(R.id.etname);
        mailid = findViewById(R.id.etmail);
        phone = findViewById(R.id.etphnum);
        address = findViewById(R.id.etaddress);
        depart = findViewById(R.id.spinner);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        eng = findViewById(R.id.eng);
        tel = findViewById(R.id.tel);
        hin = findViewById(R.id.hindi);

        ArrayAdapter<CharSequence> deptadap = ArrayAdapter.createFromResource(this,R.array.Departments,android.R.layout.simple_spinner_item);
        depart.setAdapter(deptadap);

    }

    public void save(View view) {

        String name = uname.getText().toString();
        String mail = mailid.getText().toString();
        String mobile = phone.getText().toString();
        String addres = address.getText().toString();
        String depat = depart.getSelectedItem().toString();
        if(male.isChecked())
        {
            Gender = male.getText().toString();
        }
        else if(female.isChecked())
        {
            Gender = female.getText().toString();
        }

        if(eng.isChecked())
        {
            langs.append("English");
        }
        if(tel.isChecked())
        {
            langs.append("\n Telugu");
        }
        if(hin.isChecked())
        {
            langs.append("\n Hindi");
        }



        Student student = new Student();

        student.setName(name);
        student.setMailid(mail);
        student.setPhno(mobile);
        student.setAddress(addres);
        student.setDepartment(depat);
        student.setGender(Gender);
        student.setLanguages(langs.toString());

        //MainActivity.database.myDao().insert(student);

        MainActivity.viewModel.insert(student);

        Toast.makeText(this, "Data Saved Sucessfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}