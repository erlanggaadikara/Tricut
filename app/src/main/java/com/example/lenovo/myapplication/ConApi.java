package com.example.lenovo.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


 class ConApi {

    //url server lexion
    private static final String BASE_URL = "http://apps.lexion.co.id/tricut/";
    private Retrofit retrofit;

    //fungsi getClient() untuk build url
    Retrofit getClient(){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
