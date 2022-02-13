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
import com.example.repositoriunidayan.R;
import com.example.repositoriunidayan.Sub_subjek;
import com.example.repositoriunidayan.pg.Pg_subjek;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class F_subjek extends Fragment {

    PageView pageView;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout no_data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_subjek,null);
        pageView=view.findViewById(R.id.pageview);
        shimmerFrameLayout=view.findViewById(R.id.shimer);
        no_data=view.findViewById(R.id.no_data);
        Global_variabel.load_asset(pageView,"loading-subjek");
        load();


        return view;
    }

    private void load() {
        shimmerFrameLayout.startShimmer();
        String url=Global_variabel.baseUrl+"api_mobile/subjek";
        StringRequest request=new StringRequest(
                1,
                url,
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
                                String id_subjek=getData.getString("id_subjek");
                                String subjek=getData.getString("subjek");
                                String jumlah=getData.getString("jumlah");
                                setData+= Pg_subjek.list(i, id_subjek, subjek, jumlah);
                            }
                            Global_variabel.load_data(pageView, Pg_subjek.main(setData));

                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[]uri=url.split("/");
                                    if(uri[2].equals("sub.subjek"))
                                    {
                                        if(getActivity()!=null)
                                        {
                                            Intent intent=new Intent(getActivity(), Sub_subjek.class);
                                            intent.putExtra("id_subjek", uri[3]);
                                            startActivity(intent);
                                        }
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
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(request);

    }
}
