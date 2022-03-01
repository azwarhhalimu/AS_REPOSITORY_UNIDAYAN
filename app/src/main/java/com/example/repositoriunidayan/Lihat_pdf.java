package com.example.repositoriunidayan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.repositoriunidayan.widget.Global_variabel;
import com.example.repositoriunidayan.widget.PageView;
import com.example.repositoriunidayan.widget.Pdf_view;


public class Lihat_pdf extends AppCompatActivity {

    Pdf_view pdfView;
    Toolbar toolbar;
    LinearLayout loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_pdf);
        toolbar=findViewById(R.id.toolbar);
        pdfView=findViewById(R.id.pdf_view);
        pdfView.getSettings().setJavaScriptEnabled(true);
        loading=findViewById(R.id.loading);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pdfView.loadUrl("https://docs.google.com/viewerng/viewer?url="+Global_variabel.domain+"pdf/"+getIntent().getStringExtra("id_repository")+".pdf");
        pdfView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                pdfView.setVisibility(View.VISIBLE);
                loading.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}