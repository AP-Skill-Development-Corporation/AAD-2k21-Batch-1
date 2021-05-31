package com.example.firebasedatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class LoginSuccessActivity extends AppCompatActivity {
ImageDecoder decoder;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        imageView = findViewById(R.id.iv);
      //  imageView.setBackgroundResource(R.drawable.flag);
        /* from internet*/
       /* Glide.with(this)
                .load("https://media.giphy.com/media/98uBZTzlXMhkk/giphy.gif")
                .into(imageView);
*/
        /*from raw folder*/
        /*Glide.with(this)
                .load(R.raw.giphy)
                .into(imageView);*/
        imageView.setImageResource(R.drawable.giphy);
    }
}