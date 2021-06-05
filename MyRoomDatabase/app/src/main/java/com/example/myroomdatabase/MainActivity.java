package com.example.myroomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;


import com.example.myroomdatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    static StudentDataBase dataBase;
    StudentEntity entity;
    List<StudentEntity> list;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBase = Room.databaseBuilder(this, StudentDataBase.class, "aad")
                .allowMainThreadQueries().build();
    }

    public void saveData(View view) {
        entity = new StudentEntity();
        entity.setName(binding.etStudentName.getText().toString());
        entity.setRollnumber(binding.etRollnumber.getText().toString());
        dataBase.studentsDao().insert(entity);
        Toast.makeText(this, "success "+
                binding.etStudentName.getText().toString(), Toast.LENGTH_SHORT).show();
binding.etStudentName.setText("");
binding.etRollnumber.setText("");
    }

    public void retriveData(View view) {

     list=dataBase.studentsDao().retrive();
        Toast.makeText(this, "total "+list.size(), Toast.LENGTH_SHORT).show();
        adapter=new StudentAdapter(this,list);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
    }
}