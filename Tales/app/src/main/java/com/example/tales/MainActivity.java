package com.example.tales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        TextView textView = findViewById(R.id.textView2);

        String[] item = getResources().getStringArray(R.array.index);

        // adapter to connect row_item page with the main page
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.row_item,R.id.textItem,item);

        listView.setAdapter(arrayAdapter);

        // now when click on list's items, show details
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // use intent to move from this to Details page
                Intent intent = new Intent(MainActivity.this,Details.class);

                //set postion of item to indicate the html page
                intent.putExtra("page",position);

                startActivity(intent);

            }
        });
    }

    public void share_click(View view) {  // share the app with through some suggested programs

        String textShare = "Heathline App";
        String shareLink = "https://play.google.com/store/apps/details?id=com.example.tales";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,textShare + "\n" + shareLink);
        startActivity(share);

    }

    public void email_click(View view) {  // go to Email

        try {

            String text = "Hello there \n My Suggestion is : ";

            Intent sendEmail = new Intent(Intent.ACTION_SEND);

            sendEmail.setData(Uri.parse("mailto:"));
            sendEmail.setType("message/rfc822");    // code to send email
            sendEmail.putExtra(Intent.EXTRA_EMAIL, "hamzimansour123@gmail.com"); //email of developer
            sendEmail.putExtra(Intent.EXTRA_SUBJECT, "About Healthline App"); //email subject
            sendEmail.putExtra(Intent.EXTRA_TEXT, text); //email text
            startActivity(sendEmail);

        }catch (Exception e){

            Toast.makeText(this,"Sorry Something Wrong",Toast.LENGTH_SHORT).show();

        }
    }

    public void close_click(View view) {  // exit the app

        finish();

    }

    public void apps_click(View view) {  // view apps of the developer in playstore

        // go to playstore and show developer's apps by link according to id
        // this link remain same except id
        Intent moreApps = new Intent(Intent.ACTION_VIEW);
        moreApps.setData(Uri.parse("https://play.google.com/store/apps/developer?id=your_Google_Play_Store_Name"));
        startActivity(moreApps);

    }
}