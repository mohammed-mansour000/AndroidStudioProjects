package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);

        String[] colors = getResources().getStringArray(R.array.colors);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.row_item,R.id.textView,colors);

        list.setAdapter(arrayAdapter);

        // when click on item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,parent.getItemAtPosition(position) + "",Toast.LENGTH_SHORT).show();

            }
        });

    }
}