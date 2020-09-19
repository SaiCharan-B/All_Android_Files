package com.example.registerandloginmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etn,ete,etu,etp;
    FirebaseDatabase database;
    DatabaseReference reference;

    List<User> usersList;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = findViewById(R.id.name);
        ete = findViewById(R.id.emailid);
        etu = findViewById(R.id.username);
        etp = findViewById(R.id.password);

        usersList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    public void register(View view) {
        final String name = etn.getText().toString();
        final String email = ete.getText().toString();
        final String uname = etu.getText().toString();
        final String pass = etp.getText().toString();

      //  User u = new User(name,email,uname,pass);
        //reference.child("Users").push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
          //  @Override
            //public void onSuccess(Void aVoid) {
              //  Toast.makeText(MainActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();

           // }
        //});
        reference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    User u = dataSnapshot.getValue(User.class);
                    usersList.add(u);
                }
                if(usersList.size() !=0)
                {
                    for(int i = 0;i<usersList.size();i++)
                    {
                        if(uname.equals(usersList.get(i).getUname()))
                        {
                            Toast.makeText(MainActivity.this, "The Username "+uname+" is already existing", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            count++;

                        }
                    }
                    if(count == usersList.size())
                    {
                        User u = new User(name,email,uname,pass);
                        reference.child("Users").push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void login(View view) {
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }
}