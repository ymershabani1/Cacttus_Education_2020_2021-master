package com.cacttuseducation2020_2021.api;

import com.cacttuseducation2020_2021.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";



    @GET("marvel")
    Call<ArrayList<Hero>> getHeroes();



}
