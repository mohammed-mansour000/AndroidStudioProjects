package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        @SuppressLint("WrongViewCast") EditText ageText = findViewById(R.id.ageText);
        int yearOfBirth = Integer.parseInt(ageText.getText().toString());
        int age = 2020-yearOfBirth;
        Toast.makeText(this,"age:"+String.valueOf(age),Toast.LENGTH_LONG).show();
    }
}