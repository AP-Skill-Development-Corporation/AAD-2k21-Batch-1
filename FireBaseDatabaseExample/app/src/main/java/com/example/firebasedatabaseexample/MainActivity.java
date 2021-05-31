package com.example.firebasedatabaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText empName,employeeId,empSal;
FirebaseDatabase database;
DatabaseReference reference;
RecyclerView recycle;
EmployeeAdapter adapter;
    Employee employeee;
    List<Employee> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empName=findViewById(R.id.empname);
        employeeId=findViewById(R.id.empId);
        empSal=findViewById(R.id.empSalaray);
        recycle=findViewById(R.id.rec);
        database= FirebaseDatabase.getInstance();
        reference=database.getReference("Employees");

    }

    public void saveDatatoFirebase(View view) {
        String ename=empName.getText().toString();
        String eid=employeeId.getText().toString();
        String esalary=empSal.getText().toString();
        if (ename.isEmpty() && eid.isEmpty() && esalary.isEmpty()){
            Toast.makeText(this, "please fill the details", Toast.LENGTH_SHORT).show();
        }else {
             employeee=new Employee(ename,eid,esalary);
            reference.push().setValue(employeee)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    empName.setText("");
                    employeeId.setText("");
                    empSal.setText("");
                    Toast.makeText(MainActivity.this, "saved success"+ename, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void retriveDatatoFirebase(View view) {
        list=new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){
                    Employee emp=ds.getValue(Employee.class);
                    list.add(emp);
                }

                adapter = new EmployeeAdapter(getApplicationContext(), list);
                recycle.setAdapter(adapter);
                recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Toast.makeText(MainActivity.this, "" + list.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void loginEvente(View view) {
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}