package com.example.lenovo.myapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TabHost tabhost = getTabHost();
            TabHost.TabSpec spec;
            Intent intent;
            //inisialisasi tab untuk class terpopuler
            intent = new Intent().setClass(this, terpopuler.class);
            spec = tabhost.newTabSpec("terpopuler").setIndicator("Barbershop", null).setContent(intent);
            tabhost.addTab(spec);
            //inisialisasi tab untuk clas trendy
            intent = new Intent().setClass(this, trendy.class);
            spec = tabhost.newTabSpec("trendy").setIndicator("Haircut",null).setContent(intent);
            tabhost.addTab(spec);
        }

}
