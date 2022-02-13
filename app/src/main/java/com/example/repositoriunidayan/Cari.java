package com.example.repositoriunidayan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.pg.Pg_cari;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Cari extends AppCompatActivity {

    Toolbar toolbar;
    EditText cari;
    PageView pageView;
    LinearLayout no_data;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari);
        cari=findViewById(R.id.form_cari);
        toolbar=findViewById(R.id.toolbar);
        no_data=findViewById(R.id.no_data);
        pageView=findViewById(R.id.pageview);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        cari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    cari(s.toString());
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void cari(String query) {
        no_data.setVisibility(View.GONE);
        pageView.setVisibility(View.VISIBLE);
        Global_variabel.load_asset(pageView,"list-cari");
        String url= Global_variabel.baseUrl+"api_mobile/cari";
        StringRequest request=new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            String data="";
                            for (int i=0; i<jsonArray.length(); i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_repository=getData.getString("id_repository");
                                String judul=getData.getString("judul");
                                String fakultas=getData.getString("fakultas");
                                String jurusan=getData.getString("jurusan");

                                data+= Pg_cari.list(id_repository, judul, fakultas,jurusan);
                            }
                            Global_variabel.load_data(pageView, Pg_cari.main(data));
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

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> form=new HashMap<String, String>();
                form.put("query", query);
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
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}