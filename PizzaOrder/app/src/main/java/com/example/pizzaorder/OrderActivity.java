package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    TextView details;
    Button order;
    RadioGroup radioGroup;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        details = findViewById(R.id.details);
        order = findViewById(R.id.order_btn);
        radioGroup = findViewById(R.id.radiogroup);
        imageView = findViewById(R.id.imageView);

        String type = getIntent().getStringExtra("type");
        final int price = getIntent().getIntExtra("price",0);
        String size = getIntent().getStringExtra("size");
        int img = getIntent().getIntExtra("img",0);

        details.setText(size + " " + price + " LL" + type + " Pizza");
        imageView.setImageResource(img);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton card = findViewById(R.id.card);
                RadioButton cash = findViewById(R.id.cash);
                RadioButton pick = findViewById(R.id.pick);
                RadioButton del = findViewById(R.id.del);
                if(cash.isChecked() && pick.isChecked()){
                    Toast.makeText(getApplicationContext(),"you will pay by "+ cash.getText().toString() + " on "+ pick.getText().toString(),Toast.LENGTH_SHORT).show();
                }else if(card.isChecked() && pick.isChecked()){
                    Toast.makeText(getApplicationContext(),"you will pay by "+ card.getText().toString() + " on "+ pick.getText().toString(),Toast.LENGTH_SHORT).show();
                }else if(cash.isChecked() && del.isChecked()){
                    Toast.makeText(getApplicationContext(),"you will pay by "+ cash.getText().toString() + " on "+ del.getText().toString(),Toast.LENGTH_SHORT).show();
                }else if(card.isChecked() && del.isChecked()){
                    Toast.makeText(getApplicationContext(),"you will pay by "+ card.getText().toString() + " on "+ del.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill All Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}