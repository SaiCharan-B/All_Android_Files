package com.example.roomlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static StudentDatabase database;

    RecyclerView rv;


    static MyViewModel viewModel;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*database = Room.databaseBuilder(this,StudentDatabase.class,"MYDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
*/
        rv = findViewById(R.id.recycler);
        tv = findViewById(R.id.textview);

        /* To initialize the view model */
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }
        });

       // List<Student> studentList = database.myDAO().readData();

        /* for retrieving data */
        viewModel.readData().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                if(students.size()==0)
                {
                    tv.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.GONE);
                }
                else
                {
                    tv.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rv.setAdapter(new MyDataAdapter(MainActivity.this,students));

                }

            }
        });

        /*rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyDataAdapter(this,studentList));
*/
       /* for(int i=0;i<studentList.size();i++)
        {
            Toast.makeText(this, ""+i, Toast.LENGTH_LONG).show();

            Toast.makeText(this, ""+studentList.get(i).getRollNumber(), Toast.LENGTH_LONG).show();
        }*/
    }
}