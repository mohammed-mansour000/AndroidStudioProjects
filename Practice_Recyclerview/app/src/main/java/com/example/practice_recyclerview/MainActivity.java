package com.example.practice_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.myrv);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(R.drawable.ic_launcher_background,"cat 1"));
        cats.add(new Cat(R.drawable.ic_launcher_background,"cat 2"));
        cats.add(new Cat(R.drawable.ic_launcher_background,"cat 3"));


        Adapter adapter = new Adapter(cats); //create object to setAdapter()
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);//object to setLayoutManager, you can use linear or grid
        rv.setHasFixedSize(true);   // add this to improve the performance
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}