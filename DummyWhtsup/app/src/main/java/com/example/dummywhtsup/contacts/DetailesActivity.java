package com.example.dummywhtsup.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dummywhtsup.R;

public class DetailesActivity extends AppCompatActivity {
TextView tName,tNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes);
        tName=findViewById(R.id.tv_name);
        tNumber=findViewById(R.id.tv_number);
        Intent i=getIntent();
        String n=i.getStringExtra("key_name");
        String nn=i.getStringExtra("key_number");
        tName.setText(n);
        tNumber.setText(nn);

    }
}