package com.cacttuseducation2020_2021.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation2020_2021.R;
import com.cacttuseducation2020_2021.models.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroesAdapter extends BaseAdapter {


    Context context;
    ArrayList<Hero> arrayList;
    LayoutInflater layoutInflater;

    public HeroesAdapter(Context context, ArrayList<Hero> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.hero_cell, null);
        ImageView ivHero = view.findViewById(R.id.ivHero);
        TextView tvName = view.findViewById(R.id.tvHeroName);
        TextView tvRealName = view.findViewById(R.id.tvRealName);
        TextView tvFirstAppearance = view.findViewById(R.id.tvFirstAppearance);

        Hero hero = arrayList.get(position);

        Picasso.get().load(hero.getImageurl()).placeholder(R.mipmap.ic_launcher).into(ivHero);

        tvName.setText("Name: " + hero.getName());
        tvRealName.setText("Real Name: " + hero.getRealname());
        tvFirstAppearance.setText("First Appearance: "+hero.getFirstappearance());

        return view;
    }
}
