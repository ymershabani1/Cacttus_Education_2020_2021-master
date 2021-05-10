package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.models.Hero;
import com.squareup.picasso.Picasso;

public class HeroesDetailsActivity extends AppCompatActivity {
    ImageView ivHero;
    TextView tvBio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_details);

        ivHero = findViewById(R.id.ivHero);
        tvBio = findViewById(R.id.tvBio);

        Hero hero = (Hero) getIntent().getSerializableExtra("heroObject");


        System.out.println("Name arrived: " + hero.getName());

        Picasso.get().load(hero.getImageurl()).placeholder(R.mipmap.ic_launcher).into(ivHero);
        tvBio.setText(hero.getBio());


    }
}