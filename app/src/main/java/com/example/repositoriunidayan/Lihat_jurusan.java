package com.example.repositoriunidayan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.pg.Pg_jurusan;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Lihat_jurusan extends AppCompatActivity {

   Toolbar toolbar;
   PageView pageView;
   ShimmerFrameLayout shimmerFrameLayout;
   LinearLayout no_data;
   Button kembali;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_jurusan);
        toolbar=findViewById(R.id.toolbar);
        pageView=findViewById(R.id.pageview);
        setSupportActionBar(toolbar);
        shimmerFrameLayout=findViewById(R.id.shimer);
        no_data=findViewById(R.id.no_data);
        kembali=findViewById(R.id.kembali);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        load();
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

    void load()
    {
        pageView.setVisibility(View.GONE);
        shimmerFrameLayout.setVisibility(View.VISIBLE);

        String url=Global_variabel.baseUrl+"api_mobile/jurusan";
        StringRequest request=new StringRequest(
                1, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            String data="";
                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_jurusan=getData.getString("id_jurusan");
                                String jurusan=getData.getString("jurusan");
                                String jumlah=getData.getString("jumlah");
                                data+=Pg_jurusan.list(
                                        i, id_jurusan,
                                        jurusan, jumlah
                                );
                            }
                            Global_variabel.load_data(pageView, Pg_jurusan.main(data, jsonObject.getString("fakultas")));
                            pageView.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.setVisibility(View.GONE);

                            pageView.setWebViewClient(new WebViewClient(){

                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[] uri=url.split("/");
                                    if(uri[2].equals("lihat.list_repository"))
                                    {
                                        Intent intent=new Intent(getApplicationContext(), List_repository.class);
                                        intent.putExtra("id_jurusan", uri[3]);
                                        startActivity(intent);
                                    }
                                    return true;
                                }
                            });

                            if(jsonArray.length()<1)
                            {
                                    no_data.setVisibility(View.VISIBLE);
                                    pageView.setVisibility(View.GONE);
                            }
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
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form=new HashMap<String, String>();
                form.put("id_fakultas", getIntent().getStringExtra("id_fakultas"));
                return form;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}