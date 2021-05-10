package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;

public class RegisterActivity extends AppCompatActivity {

    TextView tvLoginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getIntent().getExtras() != null){
            boolean value = getIntent().getBooleanExtra("celesi",false);
            System.out.println("Vlera ne ardhje si boolean: " + value);
        }


        tvLoginHere = findViewById(R.id.tvLoginHere);
        tvLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = getIntent();
        intent.putExtra("key","Cacttus Education");
        setResult(RESULT_OK,intent);
        finish();


    }



}