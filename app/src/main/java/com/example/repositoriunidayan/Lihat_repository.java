package com.example.repositoriunidayan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.pg.Pg_lihat_repository;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Lihat_repository extends AppCompatActivity {

    Toolbar toolbar;
    PageView pageView;
    Button lihat_pdf;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_repository);
        pageView=findViewById(R.id.pageview);
        lihat_pdf=findViewById(R.id.lihat_pdf);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        load();
        lihat_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Lihat_pdf.class);
                intent.putExtra("id_repository", getIntent().getStringExtra("id_repository"));
                startActivity(intent);
            }
        });

    }

    private void load() {
        String url= Global_variabel.baseUrl+"api_mobile/lihat_repository";
        Log.d("aja", url);
        StringRequest request=new StringRequest(
                1, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);

                            String id_repository=jsonObject.getString("id_repository");
                            String judul=jsonObject.getString("judul");
                            String koleksi=jsonObject.getString("koleksi");
                            String fakultas=jsonObject.getString("fakultas");
                            String jurusan=jsonObject.getString("jurusan");
                            String subjek=jsonObject.getString("subjek");
                            String sub_subjek=jsonObject.getString("sub_subjek");

                            String abstrak=jsonObject.getString("abstrak");
                            String author=jsonObject.getString("author");
                            String pembimbing=jsonObject.getString("pembimbing");
                            String size=jsonObject.getString("size");
                            String setDAta=Pg_lihat_repository.main(
                                    id_repository,
                                    judul,
                                    koleksi,
                                    fakultas,
                                    jurusan,
                                    subjek,
                                    sub_subjek,
                                    abstrak,
                                    author,
                                    pembimbing,
                                    size

                            );
                            Global_variabel.load_data(pageView,setDAta );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form=new HashMap<String, String>();
                form.put("id_repository", getIntent().getStringExtra("id_repository"));
                return form;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        return super.onSupportNavigateUp();

    }
}