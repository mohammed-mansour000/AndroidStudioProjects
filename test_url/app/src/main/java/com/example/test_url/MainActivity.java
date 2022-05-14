package com.example.test_url;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Glide.with(this).load("https://ibb.co/Vj7yNqC").into(imageView);

//        URL url = null;
//        try {
//            url = new URL("http://goo.gl/gEgYUd");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Bitmap bitmap = null;
//        try {
//            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        imageView.setImageBitmap(bitmap);
    }

}