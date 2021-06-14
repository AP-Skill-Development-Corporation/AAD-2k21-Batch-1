package com.example.menusinandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
int day,month,year,min,hours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
               showAlert();//alt +enter
               break;
           case R.id.datepicker:
               showDate();
               break;
           case R.id.timepicker:
               showTime();
               break;
           case R.id.search:
               Toast.makeText(this, "search Item clicked ", Toast.LENGTH_SHORT).show();
               break;

       }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert..!");
        builder.setMessage("Do you want close the app ..?");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           dialogInterface.dismiss();
            }
        });
        builder.show();


    }
    private void showDate(){
        Calendar c=Calendar.getInstance();
        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                /*month name come under the srting array-->start index vallue is 0->
                * Jan -0
                * feb -1
                * jun -5*/
                String date=i+"-"+(i1+1)+"-"+i2;
                Toast.makeText(MainActivity.this, ""+date, Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
        dialog.show();


    }
    private void showTime(){
        Calendar c=Calendar.getInstance();
        min=c.get(Calendar.MINUTE);
        hours=c.get(Calendar.HOUR_OF_DAY);
        TimePickerDialog dialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String time=i+"-"+i1;
                Toast.makeText(MainActivity.this, "now time is "+time, Toast.LENGTH_SHORT).show();
            }
        },hours,min,false);
        dialog.show();

    }
}