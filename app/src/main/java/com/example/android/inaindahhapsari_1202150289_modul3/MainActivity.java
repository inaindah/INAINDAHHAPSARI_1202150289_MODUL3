package com.example.android.inaindahhapsari_1202150289_modul3;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 25/02/2018.
 */

public class MainActivity extends AppCompatActivity {
    private List<Menu> menuList = new ArrayList<Menu>();
    private RecyclerView recyclerView;
    private MenuAdapter mAdapter;
    Configuration newConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleMinuman);
        mAdapter = new MenuAdapter(this, menuList);
        //Menginisiasi adapter untuk recycleView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // /Menghubungkan adapter dan layout
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMenuData();
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }
    private void prepareMenuData() {                                                                                    //memasukkan beberapa menu ke dalam array objek
        String[] merk_title = getResources().getStringArray(R.array.merkMinuman);
        String[] merk_deskripsi = getResources().getStringArray(R.array.merkDeskripsi);
        String[] details = getResources().getStringArray(R.array.detailMinuman);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.gambarMinuman);
        //Clear the existing data (to avoid duplication)
        menuList.clear();


        //Membuat ArrayList dari Sport object,
        // images dan informasi tentang setiap sport
        for(int i=0; i<merk_title.length; i++){
            menuList.add(new Menu(sportsImageResources.getResourceId(i,0),merk_title[i], merk_deskripsi[i]
                    , details[i]));
        }

        //Recycle the typed array
        sportsImageResources.recycle();

        //notifikasi dari adapter yang dipilih
        mAdapter.notifyDataSetChanged();
    }
}
