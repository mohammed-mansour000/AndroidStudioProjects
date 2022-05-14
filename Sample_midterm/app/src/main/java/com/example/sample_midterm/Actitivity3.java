package com.example.sample_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Actitivity3 extends AppCompatActivity {
    TextView model_year , rent_rate;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actitivity3);

        model_year = findViewById(R.id.year_model);
        rent_rate = findViewById(R.id.textView3);
        imageView = findViewById(R.id.imageView);

        String model = getIntent().getStringExtra("model");
        int year = getIntent().getIntExtra("year",0);
        double rent = getIntent().getDoubleExtra("rent",0);
        int img = getIntent().getIntExtra("img",0);

        model_year.setText(model + "-" + year);
        rent_rate.setText(rent + "");
        imageView.setImageResource(img);


    }
}