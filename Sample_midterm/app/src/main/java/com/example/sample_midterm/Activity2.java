package com.example.sample_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ListView ls = findViewById(R.id.ls);

        ArrayAdapter<Car> carArrayAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1,Data.cars);
        ls.setAdapter(carArrayAdapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Activity2.this,Actitivity3.class);
                intent.putExtra("img",Data.cars[position].getImageId());
                intent.putExtra("model",Data.cars[position].getModel());
                intent.putExtra("rent",Data.cars[position].getRentPerDay());
                intent.putExtra("year",Data.cars[position].getYear());
                startActivity(intent);
            }
        });
    }
}