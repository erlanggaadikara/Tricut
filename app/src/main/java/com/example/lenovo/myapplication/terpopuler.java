package com.example.lenovo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class terpopuler extends Activity implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    SearchView search;

    private ArrayList<getdata> result = new ArrayList<>();
    private RecyclerViewAdapter viewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarsalon);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        search = (SearchView) findViewById(R.id.search);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        search.setOnQueryTextListener(this);

        loadDataSalon();
    }

    private void loadDataSalon(){
        final ConApi conapi = new ConApi();
        Retrofit retrofit = conapi.getClient();
        RegisterApi api = retrofit.create(RegisterApi.class);
        Call<Value> call = api.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                if(value.equals("1")){
                    result = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(terpopuler.this, result);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onQueryTextChange(String s) {
        s = s.toLowerCase();
        ArrayList datafilter = new ArrayList<>();
        for(getdata data1 : result){
            String nama = data1.getNamasalon().toLowerCase();
            if(nama.contains(s)){
                datafilter.add(data1);
            }
        }
        viewAdapter.setFilter(datafilter);
    return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }
}
