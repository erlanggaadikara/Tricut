package com.example.lenovo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String url = "http://apps.lexion.co.id/tricut/";
    private Context context;
    private ArrayList<getdata> resultList;
    private ArrayList<getdata> filterlList;

    public RecyclerViewAdapter(Context context, ArrayList<getdata> resultList){
        this.context = context;
        this.resultList = resultList;
        this.filterlList = resultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_terpoopuler,parent,false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        getdata result = filterlList.get(position);

        holder.textViewNS.setText(result.getNamasalon());

        Picasso.with(context)
                .load(url+result.getPhoto())
                .fit()
                .into(holder.buttonPH);

        holder.buttonPH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterlList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    void setFilter(ArrayList<getdata> filter){
        filterlList = new ArrayList<>();
        filterlList.addAll(filter);
        notifyDataSetChanged();
    }

    public void passData(int position){
        Intent i = new Intent(context, detel.class);
        i.putExtra("ID_SALON", filterlList.get(position).getIdsalon());
        i.putExtra("NAMA_SALON",filterlList.get(position).getNamasalon());
        i.putExtra("ALAMAT_SALON",filterlList.get(position).getAlamatsalon());
        i.putExtra("NO_TELP",filterlList.get(position).getNotelp());
        i.putExtra("DESKRIPSI",filterlList.get(position).getDeskripsi());
        i.putExtra("PHOTO",filterlList.get(position).getPhoto());
        i.putExtra("LATITUDE",filterlList.get(position).getLatitude());
        i.putExtra("LONGITUDE",filterlList.get(position).getLongitude());
        i.putExtra("JADWAL_HARIAN",filterlList.get(position).getJadwalHarian());
        i.putExtra("HARGA",filterlList.get(position).getHarga());
        context.startActivity(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.namaSalon)TextView textViewNS;
        @BindView(R.id.imageButton4)ImageButton buttonPH;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
