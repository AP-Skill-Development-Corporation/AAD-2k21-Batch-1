package com.example.myroomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentsDao {
    @Insert
    public void insert(StudentEntity entity);

    @Delete
    public void delete(StudentEntity entity);

    @Update
    public void update(StudentEntity entity);

    @Query("select * from workshop")
    public List<StudentEntity> retrive(StudentEntity entity);
}
