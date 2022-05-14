package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int [] icons = { R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5, R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);

        String[] colors = getResources().getStringArray(R.array.colors);

        ArrayList<ListItem> listFill = new ArrayList<ListItem>();

        for(int i=0;i<colors.length;i++){

            listFill.add(new ListItem(i,icons[i],colors[i]));

        }

        ListAdapter listAdapter = new ListAdapter(listFill);

        list.setAdapter(listAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView name = view.findViewById(R.id.nameId);
                Toast.makeText(MainActivity.this, name.getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    class ListAdapter extends BaseAdapter {

        ArrayList<ListItem> listItems = new ArrayList<ListItem>();

        ListAdapter(ArrayList<ListItem> listItems) {

            this.listItems = listItems;



        }

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position).name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.row_item,null);

            final TextView id = view.findViewById(R.id.id);
            final TextView name = view.findViewById(R.id.nameId);
            ImageView image = view.findViewById(R.id.imageView);

            id.setText(String.valueOf(listItems.get(position).id));
            image.setImageResource(listItems.get(position).img);
            name.setText(listItems.get(position).name);

            final int p = position;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "image "+ (p+1), Toast.LENGTH_SHORT).show();
                }
            });

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, name.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "id= " + id.getText(), Toast.LENGTH_SHORT).show();
                }
            });


            return view;
        }
    }
}