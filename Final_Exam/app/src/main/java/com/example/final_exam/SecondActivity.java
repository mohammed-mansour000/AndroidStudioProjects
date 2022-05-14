package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private Button display_btn;
    private ListView ls;
    private RequestQueue queue;

    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayAdapter<Doctor> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        display_btn = findViewById(R.id.display);
        ls = findViewById(R.id.ls);

        final String selected_region = getIntent().getExtras().getString("selectedRegoin");

        queue = Volley.newRequestQueue(this);

        listViewAdapter = new ArrayAdapter<Doctor>(this, android.R.layout.simple_list_item_1, doctors);

        ls.setAdapter(listViewAdapter);

        display_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillListView(doctors,selected_region);
            }
        });



    }

    public void fillListView(final ArrayList<Doctor> doctors, final String selected_region) {

        String url = "https://ebony-asterisk.000webhostapp.com/clinic/getDoctors.php";

        final JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0;i < response.length();i++) {
                        JSONObject row = response.getJSONObject(i);
                        if(row.getString("Region_Description").equals(selected_region)) {
                            int phone = row.getInt("Phone");
                            String name = row.getString("Name");
                            String region = row.getString("Region_Description");
                            String specialty = row.getString("Description");
                            doctors.add(new Doctor(phone, name, region, specialty));
                        }
                    }
                    listViewAdapter.notifyDataSetChanged();

                } catch (Exception ex) {

                    Toast.makeText(SecondActivity.this, "No records found", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SecondActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}