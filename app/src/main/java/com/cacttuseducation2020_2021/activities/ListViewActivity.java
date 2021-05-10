package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.adapters.CustomAdapter;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    String countryList[] = {"Kosova","Shqiperia","Anglia","Franca","Italia","Gjermania"};

    int images[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryList); // using cell that android provides
       // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.cell_of_listview,R.id.tvCountry, countryList); // using our custom cell

        CustomAdapter customAdapter = new CustomAdapter(this,countryList,images);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

              //  Toast.makeText(ListViewActivity.this, "Item clicked: " + countryList[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListViewActivity.this, ListViewDetailsActivity.class);
                String countryClicked  = countryList[position];
                intent.putExtra("countryKey",countryClicked);
                startActivity(intent);


            }
        });

    }
}