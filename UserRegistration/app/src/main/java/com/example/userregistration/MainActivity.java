package com.example.userregistration;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlertDialog();
                break;
            case R.id.datepicker:
                showDate();
                break;
            case R.id.timepicker:
                showTime();
                break;
            case R.id.search:
                Toast.makeText(this, "clicked search ", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showTime() {
    }

    private void showDate() {
    }

    private void showAlertDialog() {
        /*Alert Dilog Creation
        * title
        * message
        * icon
        * positive button and negitive
        * ..etc*/
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("Do you want close app..?");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.show();



    }
}