package com.example.repositoriunidayan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.List_repository_koleksi;
import com.example.repositoriunidayan.R;
import com.example.repositoriunidayan.pg.Pg_koleksi;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class F_koleksi extends Fragment {


    PageView pageView;
    LinearLayout no_internet;
    ShimmerFrameLayout shimmerFrameLayout;
    Button coba_lagi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_koleksi,null);
        if(view!=null)
        {
            shimmerFrameLayout=view.findViewById(R.id.shimer);
            coba_lagi=view.findViewById(R.id.coba_lagi);
            no_internet=view.findViewById(R.id.no_internet);
            pageView=view.findViewById(R.id.pageview);

            coba_lagi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    load();
                }
            });

           load();
        }

        return view;
    }

    private void load() {

        Global_variabel.load_asset(pageView, "loading-koleksi");
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        no_internet.setVisibility(View.GONE);
        shimmerFrameLayout.startShimmer();
        String url=Global_variabel.baseUrl+"api_mobile/koleksi";
        StringRequest request=new StringRequest(
                1, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            String setData="";
                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_koleksi=getData.getString("id_koleksi");
                                String koleksi=getData.getString("koleksi");
                                String jumlah=getData.getString("jumlah");

                                setData+= Pg_koleksi.list(
                                        id_koleksi,
                                        koleksi,
                                        jumlah
                                );

                            }

                            Global_variabel.load_data(pageView, Pg_koleksi.main(setData));
                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[]uri=url.split("/");
                                    if(uri[2].equals("list.repository"))
                                    {
                                        Intent intent=new Intent(getActivity(), List_repository_koleksi.class);
                                        intent.putExtra("id_koleksi", uri[3]);
                                        startActivity(intent);


                                    }
                                    return true;
                                }
                            });
                            shimmerFrameLayout.stopShimmer();
                            shimmerFrameLayout.hideShimmer();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(getActivity()!=null)
                {
                    no_internet.setVisibility(View.VISIBLE);
                    shimmerFrameLayout.setVisibility(View.GONE);
                }
            }
        }
        );
        if(getActivity()!=null) {
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(request);
        }
    }
}
