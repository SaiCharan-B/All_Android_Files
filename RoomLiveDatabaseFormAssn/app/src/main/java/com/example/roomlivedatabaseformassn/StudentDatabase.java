package com.example.roomlivedatabaseformassn;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO myDao();

    public static StudentDatabase database;

    public static synchronized StudentDatabase getDataBase(Context context)
    {
        if (database==null){
            database = Room.databaseBuilder(context,StudentDatabase.class,"MYDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }
}
