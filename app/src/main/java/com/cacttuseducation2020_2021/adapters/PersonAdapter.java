package com.cacttuseducation2020_2021.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.models.Person;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> personArrayList = new ArrayList<>();
    LayoutInflater inflater;

    public PersonAdapter(Context context, ArrayList<Person> arrayList){
        this.context = context;
        this.personArrayList = arrayList;
        inflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.person_cell_of_listview,null);

        ImageView ivPerson = view.findViewById(R.id.ivPerson);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvSurname = view.findViewById(R.id.tvSurname);


        Person person = personArrayList.get(position);

        ivPerson.setImageResource(person.getImage());
        tvName.setText(person.getName());
        tvSurname.setText(person.getSurname());


        return view;
    }
}
