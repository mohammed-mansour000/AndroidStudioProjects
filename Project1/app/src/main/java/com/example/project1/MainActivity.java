package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String record="";
    TextView textView;

    ImageView temperature,length,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperature = findViewById(R.id.temp_img);
        length = findViewById(R.id.length_img);
        weight = findViewById(R.id.weight_img);

        //click on temperature image
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Temperature.class);
                startActivity(intent);
            }
        });

        //click on length image
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Length.class);
                startActivity(intent);
            }
        });

        //click on weight image
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Weight.class);
                startActivity(intent);
            }
        });



//        textView = findViewById(R.id.textView5);
//        spinner = findViewById(R.id.spinner2);
//        adapter = ArrayAdapter.createFromResource(this,R.array.spinner_item,android.R.layout.simple_spinner_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                //use position value
//                switch(position){
//
//                    case 0:
//                    record = parent.getItemAtPosition(0).toString();
//                    break;
//
//                    case 1:
//                        record = parent.getItemAtPosition(1).toString();
//                        break;
//
//                    case 2:
//                        record = parent.getItemAtPosition(2).toString();
//                        break;
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//    }
//    public void display(View view){
//        textView.setText(record);
//    }
    }
}