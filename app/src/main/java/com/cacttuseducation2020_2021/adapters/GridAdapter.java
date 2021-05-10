package com.cacttuseducation2020_2021.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.models.Company;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<Company> arrayList;
    LayoutInflater inflater;

    public GridAdapter(Context context, ArrayList<Company> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.gridview_cell,null);

        ImageView ivCompany = view.findViewById(R.id.ivCompany);
        TextView tvCompany = view.findViewById(R.id.tvCompany);
        TextView tvValue = view.findViewById(R.id.tvValue);

        Company company = arrayList.get(i);

        ivCompany.setImageResource(company.getCompanyImage());
        tvCompany.setText(company.getCompanyName());
        tvValue.setText(company.getCompanyValue());

        return view;
    }
}
