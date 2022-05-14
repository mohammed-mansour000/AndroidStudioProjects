package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Button bt;
    private RequestQueue queue;
    private Spinner spinner;
    private ArrayList<String> regoin = new ArrayList<>();
    private ArrayAdapter<String> spinnerAdapter;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://ebony-asterisk.000webhostapp.com/clinic/clinic.jpg";

        iv = findViewById(R.id.imageView);
        bt = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        queue = Volley.newRequestQueue(this);

        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                iv.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);


        fillRegoin(regoin);
        spinnerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, regoin);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedRegoin = regoin.get(index).toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("selectedRegoin",selectedRegoin);
                startActivity(intent);
            }
        });

    }

    public void fillRegoin(final ArrayList<String> regoin) {

        String url_regoin = "https://ebony-asterisk.000webhostapp.com/clinic/getRegion.php";

        JsonArrayRequest request = new JsonArrayRequest(url_regoin, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0;i < response.length();i++) {
                        JSONObject row = response.getJSONObject(i);
                        String name = row.getString("Region_Description");
                        regoin.add(name);
                    }
                    spinnerAdapter.notifyDataSetChanged();

                } catch (Exception ex) {

                    Toast.makeText(getApplicationContext(), "No records found", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}