package com.example.repositoriunidayan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.Lihat_jurusan;
import com.example.repositoriunidayan.R;
import com.example.repositoriunidayan.pg.Pg_fakultas;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class F_fakultas extends Fragment {

    String fakultas;
    PageView pageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_fakultas,null);
        pageView=view.findViewById(R.id.pageview);
        Global_variabel.load_asset(pageView, "fakultas");
        load();
        return view;

    }

    void load()
    {
        String url=Global_variabel.baseUrl+"api_mobile/fakultas";
        StringRequest request=new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            String list="";
                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject getData=jsonArray.getJSONObject(i);
                                String id_fakultas=getData.getString("id_fakultas");
                                String fakultas=getData.getString("fakultas");
                                String jurusan=getData.getString("jurusan");
                                String karya_tulis=getData.getString("karya_tulis");
                                list+= Pg_fakultas.list(i,id_fakultas, fakultas, jurusan, karya_tulis);
                            }

                            Global_variabel.load_data(pageView, Pg_fakultas.main(list));

                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[] uri=url.split("/");
                                    if(uri[2].equals("lihat.jurusan"))
                                    {
                                        Intent intent=new Intent(getActivity(), Lihat_jurusan.class);
                                        intent.putExtra("id_fakultas", uri[3]);
                                        startActivity(intent);
                                    }
                                    return true;
                                }
                            });

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
        RequestQueue requestQueue=Volley.newRequestQueue(getActivity());
        requestQueue.add(request);

    }



}
