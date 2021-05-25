package com.example.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et_uname,et_mobile;
RatingBar mRating;
SeekBar mSeekBar;
TextView tv_label;
Switch mSwitch;
/*11 components */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*connect ID's here*//*11 ids*/
        et_uname=findViewById(R.id.et_username);
        et_mobile=findViewById(R.id.mobile);
        mRating=findViewById(R.id.rb);
        mSeekBar=findViewById(R.id.sb);
        tv_label=findViewById(R.id.tv);/*ctrl + d -->for entire line duplicate*/
        mSwitch=findViewById(R.id.sButton);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "On State", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Off State", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv_label.setText("Rating "+v);
            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_label.setText("Progress is "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void submitValues(View view) {
        String userName=et_uname.getText().toString();
        String usermobile=et_mobile.getText().toString();
        tv_label.setText(userName+"\n"+usermobile);

    }

}