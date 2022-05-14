package com.example.tales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        WebView webView = findViewById(R.id.webViewId);

        Intent data = getIntent();

        // recieve the position from mainactivity
        int page_num = data.getExtras().getInt("page");

        webView.loadUrl("file:///android_asset/html/"+ (page_num + 1) + ".html"); //we increment 1 because it start with index 0
    }
}