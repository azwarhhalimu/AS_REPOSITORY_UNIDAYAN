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
import com.example.repositoriunidayan.pg.Pg_list_repository_koleksi;
import com.example.repositoriunidayan.pg.Pg_list_repository_subjek;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class List_repository_subjek extends AppCompatActivity {

    Toolbar toolbar;
    PageView pageView;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout no_data;
    Button kembali;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_repository_subjek);
        toolbar=findViewById(R.id.toolbar);
        pageView=findViewById(R.id.pageview);
        kembali=findViewById(R.id.kembali);
        no_data=findViewById(R.id.no_data);
        shimmerFrameLayout=findViewById(R.id.shimer);
        kembali
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        load();
    }

    private void load() {
        String url= Global_variabel.baseUrl+"api_mobile/list_repository_subjek";
        StringRequest request=new StringRequest(1,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String subjek=jsonObject.getString("subjek");
                            String sub_subjek=jsonObject.getString("sub_subjek");
                            JSONArray jsonArray= jsonObject.getJSONArray("data");
                            String setData="";
                          //  String koleksi= jsonObject.getString("koleksi");
                            for ( int i=0; i<jsonArray.length(); i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_repository=getData.getString("id_repository");
                                String judul=getData.getString("judul");
                                String _subjek=getData.getString("subjek");
                                String _sub_subjek=getData.getString("sub_subjek");
                                String fakultas=getData.getString("fakultas");
                                String jurusan= getData.getString("jurusan");
                                String tahun=getData.getString("tahun");
                                String tanggal=getData.getString("tanggal");
                                setData+= Pg_list_repository_koleksi.list(
                                        id_repository,
                                        judul,
                                        fakultas,
                                        jurusan,
                                        tanggal,
                                        tahun, subjek,
                                        sub_subjek
                                );
                            }
                            Global_variabel.load_data(pageView, Pg_list_repository_subjek.main(setData,subjek, sub_subjek));
                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[] uri=url.split("/");
                                    if(uri[2].equals("lihat.repository"))
                                    {
                                        Intent intent=new Intent(getApplicationContext(), Lihat_repository.class);
                                        intent.putExtra("id_repository", uri[3]);
                                        startActivity(intent);
                                    }
                                    return true;
                                }
                            });
                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();
                            if(jsonArray.length()<1)
                            {
                                no_data.setVisibility(View.VISIBLE);
                                shimmerFrameLayout.setVisibility(View.GONE);
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
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form=new HashMap<String,String>();
                form.put("id_sub_subjek", getIntent().getStringExtra("id_sub_subjek"));
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