package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.models.ColorBook;
import com.cacttuseducation2020_2021.models.FactBook;

public class FunFactsActivity extends AppCompatActivity {
    Button btnShowAnotherFunFact;
    TextView tvFact, tvDidYouKnow;
    RelativeLayout relHolder;

    FactBook factBook = new FactBook();
    ColorBook colorBook = new ColorBook();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        findViews();
        onClicks();

    }

    private void onClicks() {
        btnShowAnotherFunFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = factBook.getFact();
                tvFact.setText(fact);

                int color = colorBook.getColor();
                relHolder.setBackgroundColor(color);
                btnShowAnotherFunFact.setTextColor(color);

//                tvDidYouKnow.setVisibility(View.VISIBLE);

            }
        });
    }

    private void findViews() {
        btnShowAnotherFunFact = findViewById(R.id.btnShowAnotherFunFact);
        tvFact = findViewById(R.id.tvFact);
        relHolder = findViewById(R.id.relHolder);
        tvDidYouKnow = findViewById(R.id.tvDidYouKnow);
    }
}