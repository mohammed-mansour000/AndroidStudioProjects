package com.example.pizzaorder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        ListView ls = findViewById(R.id.ls);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Pizza.pizzaType){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView)v).setTextSize(24);
                ((TextView)v).setGravity(Gravity.CENTER);
                ((TextView)v).setText(Pizza.pizzaSize[position] + " " + Pizza.pizzaPrice[position] + " LL");
                return v;
            }
        };
        ls.setAdapter(arrayAdapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListPizza.this,OrderActivity.class);
                intent.putExtra("img",Pizza.pizzaImage[position]);
                intent.putExtra("price",Pizza.pizzaPrice[position]);
                intent.putExtra("size",Pizza.pizzaSize[position]);
                intent.putExtra("type",Pizza.pizzaType[position]);
                startActivity(intent);
            }
        });
    }
}