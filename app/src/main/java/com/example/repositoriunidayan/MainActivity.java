package com.example.repositoriunidayan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.repositoriunidayan.fragment.F_Home;
import com.example.repositoriunidayan.fragment.F_fakultas;
import com.example.repositoriunidayan.fragment.F_favorit;
import com.example.repositoriunidayan.fragment.F_koleksi;
import com.example.repositoriunidayan.fragment.F_subjek;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        load_fragment(new F_Home());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
    Boolean load_fragment(Fragment fragment)
    {
        if(fragment!=null){
           FragmentManager fragmentManager=getSupportFragmentManager();
           fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
           return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.beranda:
                load_fragment(new F_Home());
                return true;
            case R.id.koleksi:
                load_fragment(new F_koleksi());
                return true;
            case R.id.fakultas:
                load_fragment(new F_fakultas());
                return true;
            case R.id.subjek:
                load_fragment(new F_subjek());
                return true;
//            case R.id.favorit:
//                load_fragment(new F_favorit());
//                return true;
        }
        return false;
    }
}