package com.cacttuseducation2020_2021.models;

import android.graphics.Color;

import java.util.Random;

public class ColorBook {
    public String[] colors={"#39add1",
            "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b",
            "#838cc7",
            "#7d669e",
            "#53bbb4",
            "#51b46d",
            "#e0ab18",
            "#637a91",
            "#f092b0",
            "#b7c0c7"};


    public int getColor(){
        String color;

        Random random = new Random();

        int randomInt = random.nextInt(colors.length);

        color = colors[randomInt];

        int colorAsInt = Color.parseColor(color);

        return colorAsInt;

    }

}
