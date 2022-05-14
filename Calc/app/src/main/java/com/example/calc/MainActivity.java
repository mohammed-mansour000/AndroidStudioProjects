package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1,number2;
    private Button sum,multi;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        sum = findViewById(R.id.buttonSum);
        multi = findViewById(R.id.buttonMulti);
        textView = findViewById(R.id.textView);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();
                if(mynumber1.isEmpty() || mynumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, "please put values", Toast.LENGTH_SHORT).show();
                }
                else{

                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);
                    textView.setText(sumNum(input1, input2) + "");
                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mynumber1 = number1.getText().toString();
                String mynumber2 = number2.getText().toString();
                if(mynumber1.isEmpty() || mynumber2.isEmpty()){
                    Toast.makeText(MainActivity.this, "please put values", Toast.LENGTH_SHORT).show();
                }
                else{

                    Double input1 = Double.parseDouble(mynumber1);
                    Double input2 = Double.parseDouble(mynumber2);

                    textView.setText(multiNum(input1, input2) + "");
                }
            }
        });
    }

    public double sumNum(double number1, double number2){

        Double result = number1 + number2;
        return result;
    }

    public double multiNum(double number1, double number2){

        Double result = number1 * number2;
        return result;
    }
}