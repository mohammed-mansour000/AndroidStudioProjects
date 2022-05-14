package com.example.project_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project_api.model.Category;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private ArrayList<Category> categories = new ArrayList<Category>();
    private SwipeRefreshLayout refreshLayout;
    private JsonArrayRequest jsonArrayRequest;
    private RecyclerView recyclerView;
    private Dialog dialog;
    private CategoryAdapter categoryAdapter;
    String url = "https://jsonplaceholder.typicode.com/todos/";
    String url2 = "https://api-for-android.000webhostapp.com/getProducts.php";
    String url3 = "https://api-for-android.000webhostapp.com/save.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.category);
        refreshLayout = findViewById(R.id.swiperefresh);
        dialog = new Dialog(this);

        //refreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                categories.clear();
                getData();
            }
        });


    }

    private void getData() {

        refreshLayout.setRefreshing(true);

        jsonArrayRequest = new JsonArrayRequest(url2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {

                        jsonObject = response.getJSONObject(i);
                        Category c = new Category();
                        c.setId(jsonObject.getInt("pid"));
                        c.setCategory(jsonObject.getString("name"));

                        categories.add(c);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                adapterPush(categories);
                refreshLayout.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    private void adapterPush(ArrayList<Category> categories) {
        categoryAdapter = new CategoryAdapter(this, categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);
    }

    public void onRefresh() {
        categories.clear();
        getData();
    }

    public void addCategory(View v) {
        TextView close, title;
        final EditText cat_text;
        Button add_cat;

        dialog.setContentView(R.layout.modcat);

        title = dialog.findViewById(R.id.tt);
        close = dialog.findViewById(R.id.close);

        title.setText("any title");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        add_cat = dialog.findViewById(R.id.submit);
        cat_text = dialog.findViewById(R.id.cat_text);

        add_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = cat_text.getText().toString();
                Submit(data);
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private void Submit(final String data) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                refreshLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        categories.clear();
                        getData();
                    }
                });
                Toast.makeText(getApplicationContext(), response,  Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("cid", "9");
                params.put("name", data);
                params.put("key", "cuBubcDE");
                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
        //queue.add(stringRequest);

    }
}
