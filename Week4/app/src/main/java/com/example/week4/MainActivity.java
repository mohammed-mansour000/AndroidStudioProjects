package com.example.week4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edX, edY;
    private Button btSum;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activity created", Toast.LENGTH_SHORT).show();
        edX = findViewById(R.id.edX);
        edY = findViewById(R.id.edY);
        btSum = findViewById(R.id.btSum);
        tvResult = findViewById(R.id.tvResult);

        if (savedInstanceState != null)
            tvResult.setText(savedInstanceState.get("result").toString());

        btSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int x = Integer.parseInt(edX.getText().toString());
                    int y = Integer.parseInt(edY.getText().toString());
                    int sum = x + y;
                    tvResult.setText("The sum is " + sum);
                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Please fill all values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Activity destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    @Override
    protected void onStart() {
        //Toast.makeText(this, "Activity started", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        //Toast.makeText(this, "Activity stopped", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("result", tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}