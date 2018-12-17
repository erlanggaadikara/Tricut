package com.example.lenovo.myapplication;

import android.text.TextUtils;

/**
 * Created by Erlangga on 10/10/2018.
 */


public class getdata {

    String ID_SALON;
    String NAMA_SALON;
    String ALAMAT_SALON;
    String NO_TELP;
    String DESKRIPSI;
    String PHOTO;
    double LATITUDE;
    double LONGITUDE;
    String JADWAL_HARIAN;
    String HARGA;
    String FIDKECAMATAN;

    //ambil data ID Salon
    public String getIdsalon(){
        return ID_SALON;
    }

    //ambil data Nama Salon
    public String getNamasalon(){
        return NAMA_SALON;
    }

    //ambil data Alamat Salon
    public String getAlamatsalon(){
        return ALAMAT_SALON;
    }

    //ambil data No telepon Salon
    public String getNotelp(){
        return NO_TELP;
    }

    //ambil data Deskripsi Salon
    public String getDeskripsi(){
        return DESKRIPSI;
    }

    //ambil data Foto Salon
    public String getPhoto(){ return PHOTO; }


    //ambil data Latitude dan longitude Salon
    public double getLatitude(){
        return LATITUDE;
    }
    public double getLongitude(){
        return LONGITUDE;
    }

    public String getJadwalHarian(){
        return JADWAL_HARIAN;
    }
    public String getHarga(){
        return HARGA;
    }

    //ambil data FID kecamatan Salon
    public String getFidkecamatan(){
        return FIDKECAMATAN;
    }
}
