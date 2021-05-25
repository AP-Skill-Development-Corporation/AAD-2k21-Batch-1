package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
TextInputLayout mail,password,cnf_password;
EditText address_et;
Spinner states_spinner;
RadioButton m,f;
CheckBox c_lan,java_lan,p_lan;
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
        mail=findViewById(R.id.et_email);
    }
}