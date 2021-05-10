package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;

public class ListViewDetailsActivity extends AppCompatActivity {

    TextView tvCountryInDetailsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_details);

        tvCountryInDetailsActivity = findViewById(R.id.tvCountryInDetailsActivity);

        if (getIntent().getExtras() != null){
            String country = getIntent().getStringExtra("countryKey");
            //Toast.makeText(this, "Country in Details Activity is: " + country, Toast.LENGTH_SHORT).show();

            tvCountryInDetailsActivity.setText(country);

        }

    }
}