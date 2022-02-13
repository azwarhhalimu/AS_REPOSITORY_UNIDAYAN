package com.example.repositoriunidayan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.pg.Pg_sub_subjek;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Sub_subjek extends AppCompatActivity {

    Toolbar toolbar;
    PageView pageView;
    TextView label_nav;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout no_data;
    Button kembali;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_subjek);
        toolbar=findViewById(R.id.toolbar);
        label_nav=findViewById(R.id.label_nav);
        no_data=findViewById(R.id.no_data);
        kembali=findViewById(R.id.kembali);
        pageView=findViewById(R.id.pageview);
        shimmerFrameLayout=findViewById(R.id.shimer);
        Global_variabel.load_asset(pageView, "loading-sub_subjek");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        load();
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }




    private void load() {
        shimmerFrameLayout.startShimmer();
        String url= Global_variabel.baseUrl+"api_mobile/sub_subjek";
        StringRequest request=new StringRequest(1,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String subjek=jsonObject.getString("subjek");
                            label_nav.setText(subjek);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            String setData="";
                            for (int i=0; i<jsonArray.length(); i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_sub_subjek= getData.getString("id_sub_subjek");
                                String sub_subjek=getData.getString("sub_subjek");
                                String jumlah=getData.getString("jumlah");
                                setData+= Pg_sub_subjek.list(
                                        id_sub_subjek, sub_subjek,
                                        jumlah
                                );
                            }
                            Global_variabel.load_data(pageView, Pg_sub_subjek.main(setData));
                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[]uri=url.split("/");
                                    if(uri[2].equals("list.repository"))
                                    {
                                        Intent intent=new Intent(getApplicationContext(), List_repository_subjek.class);
                                        intent.putExtra("id_sub_subjek", uri[3]);
                                        startActivity(intent);
                                    }
                                    return true;
                                }
                            });

                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();
                            if(jsonArray.length()<1)
                            {
                                shimmerFrameLayout.setVisibility(View.GONE);
                                no_data.setVisibility(View.VISIBLE);
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
                Map<String, String> form=new HashMap<String, String>();
                form.put("id_subjek", getIntent().getStringExtra("id_subjek"));
                return form;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
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