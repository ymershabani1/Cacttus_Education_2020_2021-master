package com.cacttuseducation2020_2021.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.adapters.PersonAdapter;
import com.cacttuseducation2020_2021.models.Person;

import java.util.ArrayList;

public class PersonListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Person> arrayList = new ArrayList<>();
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list_view);

        listView = findViewById(R.id.personListView);
        populateArrayList();
        personAdapter = new PersonAdapter(this,arrayList);
        listView.setAdapter(personAdapter);
    }

    private void populateArrayList() {
        arrayList.add(new Person(R.mipmap.ic_launcher,"Astrit","Kurtishaj"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Diell","Dobranaj"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Egzon","Zylfijaj"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Elbunit","Ahmetaj"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Ardita","Krasniqi"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Rea","Spahiu"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Rea","Spahiu"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Rea","Spahiu"));
        arrayList.add(new Person(R.mipmap.ic_launcher,"Rea","Spahiu"));
    }
}