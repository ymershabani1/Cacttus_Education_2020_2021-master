package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.cacttuseducation2020_2021.R;

public class AnimationActivity extends AppCompatActivity {
    Button btnBounce, btnFadeInOut, btnMove;
    ImageView ivCacttus;
    Animation animationBounce, animationFadeInOut, animationMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        btnBounce = findViewById(R.id.btnBounce);
        ivCacttus = findViewById(R.id.ivCacttus);
        btnFadeInOut = findViewById(R.id.btnFadeInOut);
        btnMove = findViewById(R.id.btnMove);

        animationBounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        animationFadeInOut = AnimationUtils.loadAnimation(this,R.anim.fade_in_out);
        animationMove = AnimationUtils.loadAnimation(this, R.anim.move);

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivCacttus.startAnimation(animationBounce);
            }
        });

        btnFadeInOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivCacttus.startAnimation(animationFadeInOut);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivCacttus.startAnimation(animationMove);
            }
        });

    }
}