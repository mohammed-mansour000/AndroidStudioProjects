package com.example.listview_liu;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ls = findViewById(R.id.listView);
        ArrayAdapter<Car> carArrayAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1,Data.cars){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView)v).setTextSize(24);
                ((TextView)v).setGravity(Gravity.CENTER);
                return v;
            }
        };
        ls.setAdapter(carArrayAdapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Show_Details.class);
                intent.putExtra("pos",position);
                intent.putExtra("details",Data.cars[position].toString());
                startActivity(intent);
            }
        });
    }
}