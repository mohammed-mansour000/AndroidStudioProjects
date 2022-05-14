package com.example.fetch_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView ls = findViewById(R.id.ls);
        final ArrayList<Product> products = new ArrayList<Product>();
        final ArrayAdapter<Product> productArrayAdapter  = new ArrayAdapter<Product>(this,android.R.layout.simple_list_item_1,products);
        ls.setAdapter(productArrayAdapter);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://api-for-android.000webhostapp.com/getProducts.php";
        final JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject row = response.getJSONObject(i);
                        int pid = row.getInt("pid");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");
                        String category = row.getString("category");
                        products.add(new Product(pid, name, quantity, price, category));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show(); //for example when url is not right
                    }
                }

                productArrayAdapter.notifyDataSetChanged(); //data json will not be displayed until we call this method
            }
        }, new Response.ErrorListener() {  //error in case we dont have internet or cant access the json api
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}