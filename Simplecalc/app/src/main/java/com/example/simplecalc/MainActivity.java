package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView myresult;
    EditText number1, number2;
    Button mysum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myresult = findViewById(R.id.textView);
        number1  = findViewById(R.id.number1);
        number2  = findViewById(R.id.number2);
        mysum    = findViewById(R.id.button);

    }
    public void clickSum(View view){

        //method to check if user input is not empty
        if( !TextUtils.isEmpty(number1.getText().toString()) && !TextUtils.isEmpty(number2.getText().toString()) ) {

            double num1 = Double.parseDouble(number1.getText().toString());
            double num2 = Double.parseDouble(number2.getText().toString());
            myresult.setText("Result : " + (num1 + num2));

        }else{

            myresult.setText("Please Enter Numbers");
            //Toast.makeText(this, "no input" , Toast.LENGTH_LONG).show();

        }

    }
}