package com.example.clickableimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { //we added implements trying new way of clicklisnter

    ImageView android, java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android = findViewById(R.id.androidImage);
        java = findViewById(R.id.javaImage);

        // this is another way to use setOnClickListener(), where we split the void function
        android.setOnClickListener(this);
        java.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.androidImage:
               // Toast.makeText(MainActivity.this,"Android",Toast.LENGTH_SHORT).show();
                Intent intentAndroid = new Intent(MainActivity.this, DetailsAndroid.class);
                intentAndroid.putExtra("name","Android Programming");
                intentAndroid.putExtra("myKey","Android");
                intentAndroid.putExtra("details","Android is a mobile operating system developed by Google. It is used by several smartphones and tablets. The Android operating system (OS) is based on the Linux kernel. ... Unlike Apple's iOS, Android is open source, meaning developers can modify and customize the OS for each phone.");
                startActivity(intentAndroid);
                break;

            case R.id.javaImage:
               // Toast.makeText(MainActivity.this,"Java",Toast.LENGTH_SHORT).show();
                Intent intentJava = new Intent(MainActivity.this, DetailsAndroid.class);
                intentJava.putExtra("name","Java Programming");
                intentJava.putExtra("myKey","Java");
                intentJava.putExtra("details","Java is a popular programming language, created in 1995. It is owned by Oracle, and more than 3 billion devices run Java. It is used for: Mobile applications (specially Android apps) Desktop applications");
                startActivity(intentJava);
                break;
        }
    }
}