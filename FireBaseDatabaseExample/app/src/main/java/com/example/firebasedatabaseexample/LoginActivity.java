package com.example.firebasedatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText e_name, e_id;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<Employee> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_name = findViewById(R.id.et_empname);
        e_id = findViewById(R.id.et_empId);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Employees");
    }

    public void loginEvent(View view) {
        String ename = e_name.getText().toString();
        String eid = e_id.getText().toString();
        list = new ArrayList<>();
        if (ename.isEmpty()&& eid.isEmpty()){
            Toast.makeText(this, "Fill the details", Toast.LENGTH_SHORT).show();
        }else{
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    Employee emp=ds.getValue(Employee.class);
                    if ((ename.equals(emp.getEname())) && (eid.equals(emp.geteId()))){
                        Intent successintent=new Intent(getApplicationContext(),
                                LoginSuccessActivity.class);
                        successintent.putExtra("empname",ename);
                        startActivity(successintent);
                        break;
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "not found",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });                /*reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    Employee employee=dataSnapshot.getValue(Employee.class);
                    if ((ename.equals(employee.getEname()))&& (eid.equals(employee.geteId()))){
                        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        break;
                    }else {
                        Toast.makeText(LoginActivity.this, "faild", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
    }
    }
}