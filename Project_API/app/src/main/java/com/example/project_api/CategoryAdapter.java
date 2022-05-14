package com.example.project_api;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project_api.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Category> category;
    private String url = "https://api-for-android.000webhostapp.com/getProducts.php";

    public CategoryAdapter(Context context, ArrayList<Category> category) {
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.category_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(category.get(position).getCategory());
        holder.no.setText("#" + String.valueOf(position+1));

        holder.edit_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = category.get(position).getId();
                String  value = category.get(position).getCategory();
                editCategory(id, value);
            }
        });

        holder.delete_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = category.get(position).getId();
                String  value = category.get(position).getCategory();
                deleteCategory(id);
            }
        });
    }

    private void deleteCategory(final int id) {
        TextView close, title;
        final EditText cat_text;
        Button add_cat;
        final Dialog dialog;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.delete_cat);

        title = dialog.findViewById(R.id.tt);
        close = dialog.findViewById(R.id.close);

        title.setText("any edit");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        add_cat = dialog.findViewById(R.id.submit);


        add_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Submit("DELETE","",dialog,id);
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void editCategory(final int id, String value) {
        TextView close, title;
        final EditText cat_text;
        Button add_cat;
        final Dialog dialog;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.modcat);

        title = dialog.findViewById(R.id.tt);
        close = dialog.findViewById(R.id.close);

        title.setText("any edit");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        add_cat = dialog.findViewById(R.id.submit);
        cat_text = dialog.findViewById(R.id.cat_text);

        cat_text.setText(value);

        add_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = cat_text.getText().toString();
                Submit("PUT",data,dialog,id);
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void Submit(String method, final String data, final Dialog dialog, final int id) {

        if(method == "PUT") {

            StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    dialog.dismiss();

                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("pid", String.valueOf(id));
                    params.put("name", data);
                    return params;
                }
            };

            Volley.newRequestQueue(context).add(stringRequest);
        }else if(method == "DELETE"){

            StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url + id, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    dialog.dismiss();

                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            });

            Volley.newRequestQueue(context).add(stringRequest);
        }
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title, no;
        private ImageView edit_cat, delete_cat;

        public MyViewHolder (View view){
            super(view);
            no = view.findViewById(R.id.no);
            title = view.findViewById(R.id.cat_name);
            edit_cat = view.findViewById(R.id.edit_cat);
            delete_cat = view.findViewById(R.id.delete_cat);
        }
    }
}
