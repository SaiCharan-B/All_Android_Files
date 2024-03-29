package com.example.icebodaawotesting;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void insert(Student student);

    @Query("select * from StudentData")
    public LiveData<List<Student>> readData();

    @Delete
    public void delete(Student student);

    @Update
    public void update(Student student);
}

