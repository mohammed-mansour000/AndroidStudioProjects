package com.example.multiplepages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // get data from first page
        Bundle extras = getIntent().getExtras();
        textView = findViewById(R.id.textView5);

        String fromFirstPage = extras.getString("lastname");
        textView.setText(fromFirstPage);
    }
}