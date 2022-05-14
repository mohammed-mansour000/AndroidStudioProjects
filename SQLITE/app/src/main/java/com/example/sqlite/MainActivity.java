package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Sqlite db = new Sqlite(this);

    EditText name, email,ID;

    ListView displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameID);
        email = findViewById(R.id.emailID);
        ID = findViewById(R.id.ID);
        displayData = findViewById(R.id.displayDataID);

        onShow();
    }

    public void onAdd(View view) {

        String Name = name.getText().toString();
        String Email = email.getText().toString();
        if(!Name.isEmpty() || !Email.isEmpty()) { // check if all fields are filled
            Boolean result = db.insertData(Name, Email); // since this function return boolean

            if(result == true){
                Toast.makeText(this, "Info Added", Toast.LENGTH_SHORT).show();
                name.setText("");   // reset the enteries of name
                email.setText("");  // reset the enteries of name
                onShow();
            }else{
                Toast.makeText(this, "Add Failed", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
    }

    public void onUpdate(View view) {

        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String id = ID.getText().toString();
        if(!Name.isEmpty() || !Email.isEmpty()) { // check if all fields are filled
            Boolean result = db.updateData(id,Name, Email); // since this function return boolean

            if(result == true){
                Toast.makeText(this, "Info Updated", Toast.LENGTH_SHORT).show();
                name.setText("");   // reset the enteries of name
                email.setText("");  // reset the enteries of email
                ID.setText("");  // reset the enteries of ID
                onShow();
            }else{
                Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Fill All Fields",Toast.LENGTH_SHORT).show();
        }
    }

    public void onDelete(View view) {

        String id = ID.getText().toString();
        if(!id.isEmpty()) {
            Integer result = db.deleteData(id);  //this function return 1 when delete success and 0 when fail

            if (result == 1) {
                Toast.makeText(this, "Info Deleted", Toast.LENGTH_SHORT).show();
                name.setText("");   // reset the enteries of name
                email.setText("");  // reset the enteries of email
                ID.setText("");  // reset the enteries of ID
                onShow();
            } else {
                Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Fill ID Field",Toast.LENGTH_SHORT).show();
        }
    }

    public void onShow(){

        ArrayList<String> listData = db.getAllInfo();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listData);
        displayData.setAdapter(arrayAdapter);

    }
}