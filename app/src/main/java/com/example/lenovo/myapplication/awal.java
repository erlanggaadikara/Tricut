package com.example.lenovo.myapplication;

/**
 * Created by Erlangga on 05/02/2018.
 */

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;


public class awal extends AppCompatActivity {

    private static int interval = 2000;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_awal);

        //inisialisasi class handler untuk splashscreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(awal.this, MainActivity.class);
                startActivity(i, savedInstanceState);

                this.finish();
            }

            private void finish(){

            }
        }, interval);
    };
}
