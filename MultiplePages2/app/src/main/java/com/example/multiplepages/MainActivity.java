package com.example.multiplepages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.buttonSecond);
        button3 = findViewById(R.id.buttonThird);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to second page, first parameter is current page , second param is second page
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // transfer data from this to second page
                intent.putExtra("firstname", "Mahmoud");
                intent.putExtra("lastname", "khalil");
                intent.putExtra("welcomeMessage", "hello from first to second");
                intent.putExtra("age", 36);

                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to second page, first parameter is current page , second param is second page
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                // transfer data from this to second page
                intent.putExtra("firstname", "Mahmoud");
                intent.putExtra("lastname", "khalil");
                intent.putExtra("welcomeMessage", "hello from first to third");
                intent.putExtra("age", 36);

                startActivity(intent);
            }
        });
    }
}