package com.example.listview_liu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__details);

        ImageView iv = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView2);

        int pos = getIntent().getIntExtra("pos",0);
        String details = getIntent().getStringExtra("details");

        iv.setImageResource(Data.cars[pos].getImage());
        textView.setText(details);

    }
}