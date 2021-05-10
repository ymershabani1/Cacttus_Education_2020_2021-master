package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.cacttuseducation2020_2021.R;
import com.squareup.picasso.Picasso;

public class PandaExampleActivity extends AppCompatActivity {

    ImageView testImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda_example);

        testImageView = findViewById(R.id.testImageView);


        Picasso.get().load("http://i.imgur.com/DvpvklR.png")
                     .placeholder(R.mipmap.ic_launcher)
                     .into(testImageView);



    }
}