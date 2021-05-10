package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.preferences.Prefs;

public class PrefsExampleActivity extends AppCompatActivity {

    EditText etName,etEmail;
    Button btnSave, btnClear, btnRetrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs_example);

        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        btnClear = findViewById(R.id.btnClear);
        etEmail = findViewById(R.id.etEmail);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().length()>0 && etEmail.getText().toString().length()>0){
                    Prefs.saveString(PrefsExampleActivity.this, "name",etName.getText().toString());
                    Prefs.saveString(PrefsExampleActivity.this,"email",etEmail.getText().toString());
                }else {
                    Toast.makeText(PrefsExampleActivity.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etEmail.setText("");
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String retrievedString = Prefs.getString(PrefsExampleActivity.this,"name");
                etName.setText(retrievedString);

                String emailRetreived = Prefs.getString(PrefsExampleActivity.this,"email");
                etEmail.setText(emailRetreived);

            }
        });


    }
}