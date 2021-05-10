package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.adapters.GridAdapter;
import com.cacttuseducation2020_2021.models.Company;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;

    ArrayList<Company> arrayList = new ArrayList<>();
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridView);

        arrayList.add(new Company(R.mipmap.ic_launcher, "Apple", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Samsung", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Sony", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Dell", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Google", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Huawei", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Motorola", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Sony", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Huawei", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher, "Samsung", "100k"));

        adapter = new GridAdapter(this,arrayList);
        gridView.setAdapter(adapter);






    }
}