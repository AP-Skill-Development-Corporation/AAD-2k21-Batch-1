package com.example.myroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myroomdatabase.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    ActivityUpdateBinding updateBinding;
    StudentEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_update);
        Intent i = getIntent();
        String n = i.getStringExtra("k1");
        String r = i.getStringExtra("k2");
        updateBinding.etStudentNameUpdate.setText(n);
        updateBinding.etRollnumberUpdate.setText(r);

    }

    public void updateData(View view) {
        entity = new StudentEntity();
        entity.setName(updateBinding.etStudentNameUpdate.getText().toString());
        entity.setRollnumber(updateBinding.etRollnumberUpdate.getText().toString());
        MainActivity.dataBase.studentsDao().update(entity);
        Toast.makeText(this, "updated " +
                updateBinding.etStudentNameUpdate.getText().toString(), Toast.LENGTH_SHORT).show();
    Intent intent=new Intent(this,MainActivity.class) ;
    startActivity(intent);
    }
}