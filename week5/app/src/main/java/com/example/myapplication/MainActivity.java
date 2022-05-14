package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private RadioGroup rg;
    private CheckBox chkOlives, chkOnions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView);
        rg = findViewById(R.id.rgSize);
        chkOlives = findViewById(R.id.chkOlives);
        chkOnions = findViewById(R.id.chkOnions);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pizza size
                RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                String msg = "You selected " + rb.getText().toString() + " pizza";
                if (chkOlives.isChecked() && chkOnions.isChecked())
                    msg += " with olives and onions";
                else if (chkOlives.isChecked())
                    msg += " with olives";
                else if (chkOnions.isChecked())
                    msg += " with onions";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}