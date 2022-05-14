package com.example.internetconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_check();
    }

//    public void btn_check(View view){
//        CheckInternetConnection check = new CheckInternetConnection(getApplicationContext());
//        Boolean ch = check.isConnectingToInternet();
//        if(!ch){
//            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this,"Network Connected",Toast.LENGTH_SHORT).show();
//        }
//    }

    public void btn_check(){
        CheckInternetConnection check = new CheckInternetConnection(getApplicationContext());
        Boolean ch = check.isConnectingToInternet();
        if(!ch){
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Network Connected",Toast.LENGTH_SHORT).show();
        }
    }
}