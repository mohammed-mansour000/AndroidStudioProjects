package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    CheckBox checkOlives ,checkOnion;
    RadioGroup rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        rb = findViewById(R.id.rbsize);
        checkOlives = findViewById(R.id.checkBox);
        checkOnion = findViewById(R.id.checkBox2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rg = findViewById(rb.getCheckedRadioButtonId());
                String msg = "you selected "+ rg.getText().toString() + " Pizza ";
                if(checkOlives.isChecked() && checkOnion.isChecked()){
                    msg += " with olives and onions";
                }
                else if(checkOnion.isChecked()){
                    msg += " with onions";
                }
                else if(checkOlives.isChecked()){
                    msg +="  with olives";
                }
                Toast.makeText(MainActivity.this, msg ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}