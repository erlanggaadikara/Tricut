package com.example.lenovo.myapplication;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class detel extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.NAMA_SALON) TextView nama_salon;
    @BindView(R.id.DESKRIPSI) TextView deskripsi;
    @BindView(R.id.ALAMAT) TextView alamat;
    @BindView(R.id.NO_TELP) TextView notelp;
    @BindView(R.id.imageView10) ImageView imagView;
    @BindView(R.id.buka_w) TextView buka;
    @BindView(R.id.harga_w) TextView harga;

    GoogleMap mMap;
    SupportMapFragment mapFragment;
    String namasalon;
    double lati, longi;
    String idsalon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        final Intent intent = getIntent();

        String url = "http://apps.lexion.co.id/tricut/";

        //Data yang telah diteruskan dari class terpopuler
        idsalon = intent.getStringExtra("ID_SALON");
        nama_salon.setText(intent.getStringExtra("NAMA_SALON"));
        deskripsi.setText(intent.getStringExtra("DESKRIPSI"));
        String photo = intent.getStringExtra("PHOTO");
        //pemilik.setText(intent.getStringExtra("PEMILIK"));
        notelp.setText(intent.getStringExtra("NO_TELP"));
        alamat.setText(intent.getStringExtra("ALAMAT_SALON"));
        lati = intent.getDoubleExtra("LATITUDE", 0);
        longi = intent.getDoubleExtra("LONGITUDE",0);
        buka.setText(intent.getStringExtra("JADWAL_HARIAN"));
        harga.setText(intent.getStringExtra("HARGA"));


//        showImage(currentIndex, idsalon);

        Picasso.with(this)
                .load(url+photo)
                .fit()
                .into(imagView);

        namasalon = intent.getStringExtra("ID_SALON");
        //inisialisasi map
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
;
        LatLng map = new LatLng(lati,longi);
        mMap.addMarker(new MarkerOptions().position(map).title("Marker in "+namasalon));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(map));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(map)
                .zoom(15)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
