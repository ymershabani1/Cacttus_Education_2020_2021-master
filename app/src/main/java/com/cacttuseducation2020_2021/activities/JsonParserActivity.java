package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParserActivity extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"name\":\"Cacttus Education\",\"id\":\"33\"}}";

    TextView tvName, tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parser);

        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);


        try {

            JSONObject jsonObject = new JSONObject(JSON_STRING);
            JSONObject employeeJsonObject = jsonObject.getJSONObject("employee");


            System.out.println("Employee Name: " + employeeJsonObject.getString("name") + " ID: " +
                    employeeJsonObject.getString("id"));


            tvName.setText(employeeJsonObject.getString("name"));
            tvId.setText(employeeJsonObject.getString("id"));



        }catch (JSONException jsonException){
            jsonException.printStackTrace();
        }


    }
}