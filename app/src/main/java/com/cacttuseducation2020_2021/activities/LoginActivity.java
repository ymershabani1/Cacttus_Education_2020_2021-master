package com.cacttuseducation2020_2021.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.preferences.Prefs;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnOpenUrl;
    TextView tvLogin,tvRegisterHere;
    EditText etUsernameOrEmail, etPassword;
    public static final int REQUEST_CODE_REGISTER_ACTIVITY = 1;

    CheckBox cbRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        tvLogin = findViewById(R.id.tvLogin);
        tvRegisterHere = findViewById(R.id.tvRegiserHere);
        etUsernameOrEmail = findViewById(R.id.etUsernameOrEmail);
        etPassword = findViewById(R.id.etPassword);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        cbRememberMe = findViewById(R.id.cbRememberMe);


        tvLogin.setText("Login text was changed programmatically!");
        tvLogin.setTextColor(Color.GREEN);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsernameOrEmail.getText().toString().length()>5 && etPassword.getText().toString().length()>5){
                    Toast.makeText(LoginActivity.this, "All fields are validated!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Please type more than 5 characters!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                intent.putExtra("celesi",true);
                startActivityForResult(intent,REQUEST_CODE_REGISTER_ACTIVITY);
            }
        });

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });



        boolean isChecked = Prefs.getBoolean(LoginActivity.this,"checkbox");
        cbRememberMe.setChecked(isChecked);


        System.out.println("usernameValue: " + Prefs.getString(LoginActivity.this,"username"));

        etUsernameOrEmail.setText(Prefs.getString(LoginActivity.this,"username"));
        etPassword.setText(Prefs.getString(LoginActivity.this,"password"));


        cbRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked){
                    Prefs.saveString(LoginActivity.this, "username", etUsernameOrEmail.getText().toString());
                    Prefs.saveString(LoginActivity.this,"password",etPassword.getText().toString());
                    Prefs.saveBoolean(LoginActivity.this,"checkbox",true);
                }else {
                    Prefs.saveString(LoginActivity.this, "username", "");
                    Prefs.saveString(LoginActivity.this,"password","");
                    Prefs.saveBoolean(LoginActivity.this,"checkbox",false);
                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null){
            Toast.makeText(this, "Data are null", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == REQUEST_CODE_REGISTER_ACTIVITY && resultCode == RESULT_OK){

            String result =  data.getStringExtra("key");
            Toast.makeText(this, "Result is: " + result, Toast.LENGTH_SHORT).show();

        }

    }



}