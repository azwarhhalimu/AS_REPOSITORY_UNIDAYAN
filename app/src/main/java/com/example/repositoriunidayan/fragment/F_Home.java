package com.example.repositoriunidayan.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.repositoriunidayan.Cari;
import com.example.repositoriunidayan.Lihat_repository;
import com.example.repositoriunidayan.R;
import com.example.repositoriunidayan.pg.Pg_beranda;
import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class F_Home extends Fragment {
    PageView pageView;

    LinearLayout no_internet;
    Button coba_lagi;
    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f_home,null);
        if(view!=null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor(getResources().getString(R.color.toolbar)));
            }
            pageView=view.findViewById(R.id.pageview);
            coba_lagi=view.findViewById(R.id.coba_lagi);
            no_internet=view.findViewById(R.id.no_internet);
            Global_variabel.load_asset(pageView,"loading-beranda");
            coba_lagi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Global_variabel.load_asset(pageView,"loading-beranda");
                    load();
                }
            });
            load();

        }
        return view;
    }

    void load()
    {
        no_internet.setVisibility(View.GONE);
        pageView.setVisibility(View.VISIBLE);
        String url=Global_variabel.baseUrl+"api_mobile/beranda";
        StringRequest request=new StringRequest(1, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray populer=jsonObject.getJSONArray("data_populer");
                            String setPopuler="";
                            for (int i=0; i<populer.length(); i++){
                                JSONObject getData=populer.getJSONObject(i);
                                String id_repository =getData.getString("id_repository");
                                String judul =getData.getString("judul");
                                String subjek=getData.getString("subjek");
                                String sub_subjek=getData.getString("sub_subjek");
                                String author=getData.getString("author");
                                String tanggal=getData.getString("tanggal");
                                String reader=getData.getString("reader");
                                setPopuler+= Pg_beranda.populer(
                                        i,
                                    id_repository,
                                        judul,
                                        subjek,
                                        sub_subjek,
                                        tanggal,
                                        author,
                                        reader
                                );
                            }


                            JSONArray pilihan=jsonObject.getJSONArray("pilihan");
                            String setPilihan="";
                            for (int i=0; i<pilihan.length();i++)
                            {
                                JSONObject getData=pilihan.getJSONObject(i);
                                String id_repository =getData.getString("id_repository");
                                String judul =getData.getString("judul");
                                String subjek=getData.getString("subjek");
                                String sub_subjek=getData.getString("sub_subjek");
                                String author=getData.getString("author");
                                String tanggal=getData.getString("tanggal");
                                String reader=getData.getString("reader");
                                String koleksi=getData.getString("koleksi");
                                String fakultas=getData.getString("fakultas");
                                String jurusan=getData.getString("jurusan");

                                setPilihan+= Pg_beranda.pilihan(
                                        i,
                                        id_repository,
                                        judul,
                                        subjek,
                                        sub_subjek,
                                        tanggal,
                                        author,
                                        reader,
                                        koleksi,
                                        fakultas,
                                        jurusan
                                );

                            }
                            JSONArray lainnya=jsonObject.getJSONArray("lainnya");
                            String setLainnya="";
                            for (int i=0; i<lainnya.length();i++)
                            {
                                JSONObject getData=lainnya.getJSONObject(i);
                                String id_repository =getData.getString("id_repository");
                                String judul =getData.getString("judul");
                                String subjek=getData.getString("subjek");
                                String sub_subjek=getData.getString("sub_subjek");
                                String author=getData.getString("author");
                                String tanggal=getData.getString("tanggal");
                                String reader=getData.getString("reader");
                                String koleksi=getData.getString("koleksi");
                                String fakultas=getData.getString("fakultas");
                                String jurusan=getData.getString("jurusan");

                                setLainnya+= Pg_beranda.lainnya(
                                        i,
                                        id_repository,
                                        judul,
                                        subjek,
                                        sub_subjek,
                                        tanggal,
                                        author,
                                        reader,
                                        koleksi,
                                        fakultas,
                                        jurusan
                                );
                            }
                            Global_variabel.load_data(pageView, Pg_beranda.main(
                                    setPopuler,
                                    setPilihan,
                                    setLainnya
                            ));

                            pageView.setWebViewClient(new WebViewClient(){
                                @Override
                                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                    String[] uri=url.split("/");
                                    if(uri[2].equals("lihat.repository"))
                                    {
                                        if(getActivity()!=null) {
                                            Intent intent = new Intent(getActivity(), Lihat_repository.class);
                                            intent.putExtra("id_repository", uri[3]);
                                            startActivity(intent);

                                        }
                                    }
                                    if(uri[2].equals("go.cari"))
                                    {
                                        startActivity(new Intent(getActivity(), Cari.class));
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
                        if(getActivity()!=null) {
                           no_internet.setVisibility(View.VISIBLE);
                           pageView.setVisibility(View.GONE);
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
