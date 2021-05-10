package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.fragments.FirstFragment;
import com.cacttuseducation2020_2021.fragments.SecondFragment;

public class DrawerLayoutActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView ivOpenMenu;
    TextView tvFirstFragment, tvSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        findViews();
        onClicks();
        loadFragment(new FirstFragment());
    }

    private void onClicks() {
        tvFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                loadFragment(new FirstFragment());
            }
        });

        tvSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                loadFragment(new SecondFragment());
            }
        });

        ivOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void findViews() {

        drawerLayout = findViewById(R.id.drawerLayout);
        ivOpenMenu = findViewById(R.id.ivOpenMenu);
        tvFirstFragment = findViewById(R.id.tvFirstFragment);
        tvSecondFragment = findViewById(R.id.tvSecondFragment);
    }


    void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.relFragmentContainer,fragment);
        fragmentTransaction.commit();
    }
}