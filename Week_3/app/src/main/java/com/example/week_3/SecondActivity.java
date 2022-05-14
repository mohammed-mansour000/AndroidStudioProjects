package com.example.week_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView result = findViewById(R.id.resultId);
        btnClose = findViewById(R.id.btn_close);

        int sum = getIntent().getIntExtra("sum",0);
        result.setText("the result is " + sum);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onBackPressed(){  // function to destroy secondActivity when back, to make sure there is no repetition of secondActivity
        finish();
    }

}