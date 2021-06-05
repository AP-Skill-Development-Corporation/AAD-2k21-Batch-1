package com.example.myroomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = StudentEntity.class, version = 1, exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    public static StudentDataBase dataBase;
//for Live DB
    public static synchronized StudentDataBase getDataBase(Context context) {
    if (dataBase==null){
        dataBase= Room.databaseBuilder(context,StudentDataBase.class,"aad")
                .allowMainThreadQueries()
                .build();
    }
        return dataBase;
    }

    public abstract StudentsDao studentsDao();


}
