package com.example.week_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editX, editY;
    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editX = findViewById(R.id.editText1);
        editY = findViewById(R.id.editText2);
        btnOpen = findViewById(R.id.button);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int x = Integer.parseInt(editX.getText().toString());
                    int y = Integer.parseInt(editY.getText().toString());
                    int sum = x + y;

                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("sum",sum);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this,"please fill all fields",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}