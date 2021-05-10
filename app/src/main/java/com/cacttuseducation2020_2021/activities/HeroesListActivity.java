package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.adapters.HeroesAdapter;
import com.cacttuseducation2020_2021.api.Api;
import com.cacttuseducation2020_2021.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Hero> arrayList = new ArrayList<>();
    HeroesAdapter adapter;
    ProgressBar progressBar;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        listView = findViewById(R.id.heroesListView);
        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);

        if (hasInternetConnectivity()) {
            makeApiCallAndLoadDataIntoListView();
        }else {
            Toast.makeText(this, "No internet connection!", Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(HeroesListActivity.this,HeroesDetailsActivity.class);
                Hero hero = arrayList.get(position);
                intent.putExtra("heroObject", hero);
                startActivity(intent);

            }
        });


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                    makeApiCallAndLoadDataIntoListView();
            }
        });



    }

    private void makeApiCallAndLoadDataIntoListView() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {

                arrayList = response.body();
                adapter = new HeroesAdapter(HeroesListActivity.this,arrayList);
                listView.setAdapter(adapter);

                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);

                Toast.makeText(HeroesListActivity.this, "List loaded successfully!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable throwable) {

                Toast.makeText(HeroesListActivity.this, "Something went wrong with error: " + throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }



    boolean hasInternetConnectivity(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }





}