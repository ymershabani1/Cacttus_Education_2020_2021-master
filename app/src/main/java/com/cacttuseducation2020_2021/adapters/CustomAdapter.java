package com.cacttuseducation2020_2021.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String countryList[];
    int images[];
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] countryList, int[] images){
        this.context = context;
        this.countryList = countryList;
        this.images = images;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        //int totalItems = countryList.length;
        return countryList.length;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.cell_of_listview,null);

        TextView tvCountryName = view.findViewById(R.id.tvCountry);
        ImageView ivIcon = view.findViewById(R.id.ivIcon);


        tvCountryName.setText(countryList[position]);
        ivIcon.setImageResource(images[position]);

        return view;
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
