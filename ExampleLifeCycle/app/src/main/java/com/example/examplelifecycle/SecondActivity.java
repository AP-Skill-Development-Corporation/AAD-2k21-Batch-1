package com.example.examplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("APSSDC","Second Activity Created");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("APSSDC","Second Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("APSSDC","Second Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("APSSDC","Second Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("APSSDC","Second Activity Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("APSSDC","Second Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("APSSDC","Second Activity Destroyed");
    }
}