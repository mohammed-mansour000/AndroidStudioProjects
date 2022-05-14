package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);

        myButton = findViewById(R.id.button2);
        myText   = findViewById(R.id.textView2);

        myButton.setTextColor(Color.CYAN);
        myButton.setText(R.string.button_name);
        myButton.setBackgroundColor(Color.BLACK);

        //make the same as below function but without adding the function name in OnClick
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myText.setTextColor(Color.GRAY);
                myText.setBackgroundColor(Color.YELLOW);
                myText.setText(R.string.my_text);
            }
        });

    }

    //make function when click button text change
    //we put connection between function and button by choosing it from OnClick Attribute
//    public void clickButton(View view){
//        myText.setTextColor(Color.GRAY);
//        myText.setBackgroundColor(Color.YELLOW);
//        myText.setText(R.string.my_text);
//    }
}