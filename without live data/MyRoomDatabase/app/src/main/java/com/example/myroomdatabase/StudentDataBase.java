package com.example.myroomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = StudentEntity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
public abstract StudentsDao studentsDao();
}
