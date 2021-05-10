package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.adapters.WeatherAdapter;
import com.cacttuseducation2020_2021.models.Weather;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    ListView weatherListView;
    ArrayList<Weather> arrayList = new ArrayList<>();
    WeatherAdapter weatherAdapter;
    Button btnAddCity;

    ConstraintLayout clConfirmationPopup;
    Button btnYes, btnNo;

    int positionClicked = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherListView = findViewById(R.id.weatherListView);
        btnAddCity = findViewById(R.id.btnAddCity);
        clConfirmationPopup = findViewById(R.id.clConfirmationPopup);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);



        arrayList.add(new Weather(R.mipmap.ic_launcher,"Prishtina","Raining","3°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Prizreni","Snowing","0°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Peja","Raining","1°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Podujeva","Raining","3°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Klina","Raining","5°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Gjilani","Snowing","-3°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Mitrovica","Raining","3°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Istogu","Snowing","-2°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Kamenica","Raining","0°C"));
        arrayList.add(new Weather(R.mipmap.ic_launcher,"Prishtina","Snowing","2°C"));

        weatherAdapter = new WeatherAdapter(this,arrayList);
        weatherListView.setAdapter(weatherAdapter);


        btnAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(0,new Weather(R.mipmap.ic_launcher,"Dragash","Raining","3°C"));
                weatherAdapter.notifyDataSetChanged();
            }
        });


//        View headerView = ((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header,null,false);
//
//        weatherListView.addHeaderView(headerView);


        weatherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    Toast.makeText(WeatherActivity.this, "You clicked header ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(WeatherActivity.this, "Clicked position " + position, Toast.LENGTH_SHORT).show();
                }
            }
        });

        weatherListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(WeatherActivity.this, "onLongClicked " + i, Toast.LENGTH_SHORT).show();
//                arrayList.remove(i);
//                weatherAdapter.notifyDataSetChanged();

                clConfirmationPopup.setVisibility(View.VISIBLE);
                positionClicked = i;

                return false;
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clConfirmationPopup.setVisibility(View.GONE);
                if (positionClicked != -1) {
                    arrayList.remove(positionClicked);
                    weatherAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(WeatherActivity.this, "positonClicked is -1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clConfirmationPopup.setVisibility(View.GONE);
            }
        });




        

    }
}