package com.example.userregistration;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.userregistration.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String gender;
    String knownCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*for code indatation -->ctrl+Alt+l*/
                String email = binding.etEmail.getEditableText().toString();
                String password = binding.etPassword.getEditableText().toString();
                String cnf_password = binding.cnfEtPassword.getEditableText().toString();
                String address = binding.etAddress.getText().toString();
                String state = binding.spinnerStates.getSelectedItem().toString();
                if (binding.male.isChecked()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                if (binding.c.isChecked()&&binding.java.isChecked()&&binding.p.isChecked()){
                    knownCourse="C-lang"+"\t"+"Java"+"\t"+"Python";
                }else if (binding.c.isChecked()&&binding.java.isChecked()){
                    knownCourse="C-lang"+"\t"+"Java";
                }else if(binding.c.isChecked()&&binding.p.isChecked()){
                    knownCourse="C-lang"+"\t"+"Pyhton";
                }
                else if(binding.java.isChecked()&&binding.p.isChecked()){
                    knownCourse="Java"+"\t"+"Pyhton";
                }else if(binding.c.isChecked()){
                    knownCourse="C-lang";
                }
                else if(binding.java.isChecked()){
                    knownCourse="Java";
                }
                else if(binding.p.isChecked()){
                    knownCourse="Python";
                }

                if (email.isEmpty() || password.isEmpty() || cnf_password.isEmpty()) {
                    Snackbar.make(view, "plese fill the details", Snackbar.LENGTH_LONG).show();

                } else {
                    if (password.equals(cnf_password)) {
                        binding.tv.setText(email + "\n"
                                + password + "\n"
                                + address + "\n"
                                + state + "\n"
                                + gender+"\n"
                                +knownCourse);
                        binding.img.setImageResource(R.drawable.ic_launcher_foreground);

                    } else {
                        Snackbar.make(view, "not matching the password", Snackbar.LENGTH_LONG).show();

                    }
                }
                //Toast.makeText(MainActivity.this, ""+email, Toast.LENGTH_SHORT).show();
            }
        });
    }
}