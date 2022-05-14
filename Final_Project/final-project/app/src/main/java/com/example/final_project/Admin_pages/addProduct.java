package com.example.final_project.Admin_pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.final_project.Adapter.VolleyMultipartRequest;
import com.example.final_project.R;
import com.example.final_project.model.Url;
import com.example.final_project.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class addProduct extends AppCompatActivity {

    private EditText edID, edName, edQuantity, edPrice;
    private Spinner spCategory;
    private ProgressBar prog2;
    private Button btAdd, btUploadImage;
    private RequestQueue queue;
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayAdapter<Category> CategoryAdapter;
    private int index;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        edName = findViewById(R.id.edName);
        edPrice = findViewById(R.id.edPrice);
        spCategory = findViewById(R.id.spCategories);
        prog2 = findViewById(R.id.prog2);
        btAdd = findViewById(R.id.btAdd);
        btUploadImage = findViewById(R.id.btn_upload_img);

        queue = Volley.newRequestQueue(this);

        fillCategories(categories);
        CategoryAdapter = new ArrayAdapter<Category>(this, R.layout.spinner_style, categories);

        spCategory.setAdapter(CategoryAdapter);

        //checking the permission
        //if the permission is not given we will open setting to add permission
        //else app will not open
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.parse("package:" + getPackageName()));
            finish();
            startActivity(intent);
            return;
        }
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////

        //select category from spinner
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // upload button to get image form gallery
        btUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
            }
        });


        // add button to save the product
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                prog2.setVisibility(View.VISIBLE);
//                btAdd.setEnabled(false);
//
//                StringRequest request = new StringRequest(Request.Method.POST, Url.url_addProduct, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(addProduct.this, response, Toast.LENGTH_SHORT).show();
//                        prog2.setVisibility(View.INVISIBLE);
//                        btAdd.setEnabled(true);
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(addProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
//                        prog2.setVisibility(View.INVISIBLE);
//                        btAdd.setEnabled(true);
//                    }
//                }) {
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> params = new HashMap<>();
//                        params.put("name", edName.getText().toString());
//                        params.put("price", edPrice.getText().toString());
//                        params.put("cid", String.valueOf(categories.get(index).getCid()));
//                        params.put("key", "cuBubcDE");
//                        return params;
//                    }
//                };
//
//                queue.add(request);
//
//
//            }
//        });


        // updated add button which i've added image upload
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog2.setVisibility(View.VISIBLE);
                btAdd.setEnabled(false);

                VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, Url.url_addProduct,
                        new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        try {
                            JSONObject obj = new JSONObject(new String(response.data));
                            Toast.makeText(getApplicationContext(), obj.getString("message2"), Toast.LENGTH_SHORT).show();
                            prog2.setVisibility(View.INVISIBLE);
                            btAdd.setEnabled(true);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            prog2.setVisibility(View.INVISIBLE);
                            btAdd.setEnabled(true);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
                        prog2.setVisibility(View.INVISIBLE);
                        btAdd.setEnabled(true);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", edName.getText().toString());
                        params.put("price", edPrice.getText().toString());
                        params.put("cid", String.valueOf(categories.get(index).getCid()));
                        params.put("key", "cuBubcDE");
                        return params;
                    }


                    @Override
                    protected Map<String, DataPart> getByteData() {
                        Map<String, DataPart> params = new HashMap<>();
                        long imagename = System.currentTimeMillis();
                        params.put("pic", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                        return params;
                    }
                };

                Volley.newRequestQueue(getApplicationContext()).add(volleyMultipartRequest);
            }
        });


    }

    public void fillCategories(final ArrayList<Category> categories) {


        JsonArrayRequest request = new JsonArrayRequest(Url.url_getCategory, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0;i < response.length();i++) {
                        JSONObject row = response.getJSONObject(i);
                        int cid = row.getInt("cid");
                        String name = row.getString("name");
                        categories.add(new Category(cid, name));
                    }
                    CategoryAdapter.notifyDataSetChanged();

                } catch (Exception ex) {

                    Toast.makeText(addProduct.this, "No records found", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(addProduct.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            try {
                //getting bitmap object from uri
               bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                //displaying selected image to imageview

                //calling the method uploadBitmap to upload image
                //uploadBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


}
