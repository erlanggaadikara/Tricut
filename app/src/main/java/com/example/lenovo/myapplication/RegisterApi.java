package com.example.lenovo.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Erlangga on 10/12/2017.
 */

public interface RegisterApi {
//    @FormUrlEncoded
//    @POST("photosedit_db.php")
//    Call<Value> search(@Field("search") String search);

    //Metode untuk komunikasi dengan REST Server
    @GET("salondb.php")
    Call<Value> view();
}
