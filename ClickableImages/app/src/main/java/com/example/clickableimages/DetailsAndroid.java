package com.example.clickableimages;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsAndroid extends AppCompatActivity {

    private ImageView imageView;
    private TextView name, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.infoImage1);
        name = findViewById(R.id.name);
        info = findViewById(R.id.info);

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            String getName = extras.getString("name");  //get the name from mainActivity
            String getInfo = extras.getString("details");   //get the details from mainActivity
            String getKey = extras.getString("myKey");  //get the key which specify the details and name

            showInfo(getName,getInfo,getKey);
        }

    }

    public void showInfo(String Name, String Details, String Key){ // function to change image according to key

        if(Key.equals("Android")){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.download)); //if key=Android put android image
            name.setText(Name);
            name.setTextColor(Color.GREEN);
            info.setText(Details);
            info.setTextColor(Color.DKGRAY);
        }else{
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.java));    //if key=Java put java image
            name.setText(Name);
            name.setTextColor(Color.RED);
            info.setText(Details);
            info.setTextColor(Color.BLUE);
        }
    }

}