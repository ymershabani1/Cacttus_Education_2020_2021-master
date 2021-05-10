package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.cacttuseducation2020_2021.R;

import java.util.Locale;

public class MultiLanguageActivity extends AppCompatActivity {

    Locale myLocale;
    Button btnEnglish, btnAlbanian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_language);
        btnEnglish = findViewById(R.id.btnEnglishLanguage);
        btnAlbanian = findViewById(R.id.btnAlbanianLanguage);

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
            }
        });

        btnAlbanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("");
            }
        });


    }


    void setLocale(String lang){
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf,dm);

        //refresh activity
        Intent intent = new Intent(this, MultiLanguageActivity.class);
        startActivity(intent);
        finish();
    }
}