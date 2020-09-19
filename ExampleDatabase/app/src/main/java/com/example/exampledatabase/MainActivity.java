package com.example.exampledatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText name,roll,phonenumber,et,et1;
    DatabaseReference reference;
    RecyclerView rv;
    ArrayList<Pojo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        phonenumber = findViewById(R.id.phnumber);
        et = findViewById(R.id.sroll);
        et1 = findViewById(R.id.sphnumber);
        reference = FirebaseDatabase.getInstance().getReference("UserDetails");
        rv = findViewById(R.id.rv);
        list = new ArrayList<>();
        // To fetch the data from firebase database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    list.clear();
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                    {
                        Pojo pojo = dataSnapshot1.getValue(Pojo.class);
                        list.add(pojo);
                        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
                        rv.setAdapter(adapter);
                        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void submit(View view) {
        String uname = name.getText().toString();
        String uroll = roll.getText().toString();
        String unumber = phonenumber.getText().toString();
        if(uname.isEmpty() || uroll.isEmpty() || unumber.isEmpty())
        {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Pojo pojo = new Pojo(uname,uroll,unumber);
            reference.child(uroll).setValue(pojo);
            Toast.makeText(this, "Details Submitted", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {

        String roll = et.getText().toString();
        final String num = et1.getText().toString();
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("UserDetails").orderByChild("uroll").equalTo(roll);
        final HashMap<String,Object> map = new HashMap<>();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    map.put("unumber",num);
                    dataSnapshot1.getRef().updateChildren(map);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}