package com.example.android.inaindahhapsari_1202150289_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ASUS on 25/02/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    private List<Menu> menuList;
    CardView cv;

    public MenuAdapter(Context context, List<Menu> menuList) {
        mInflater = LayoutInflater.from(context); //Inisiasi inflater
        this.menuList = menuList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.menu_list, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Menu menu = menuList.get(position);
        holder.details.setText(menu.getHarga()); //Get value ke textView
        holder.nama.setText(menu.getNama());
        holder.layout.setBackgroundResource(menu.getGambar());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //Class MyCiewHolder
        public TextView nama, details;
        ImageView gambar;
        ConstraintLayout layout;


        public MyViewHolder(View view) {
            super(view);//Menginisiasi variable2 attribute
            nama = (TextView) view.findViewById(R.id.nama);
            details = (TextView) view.findViewById(R.id.details);
            layout = (ConstraintLayout) view.findViewById(R.id.layout_background);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {    //Ketika di klik salah satu menu
            int mPosition = getLayoutPosition();
            String element = menuList.get(mPosition).toString();
            Toast.makeText(view.getContext(), nama.getText(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), DetailActivity.class);
            int gambar = menuList.get(mPosition).getGambar();
            String komposisi = menuList.get(mPosition).getKomposisi();
            i.putExtra("gambar", gambar);   //Put extra ke intent berikutnya
            i.putExtra("nama", nama.getText());
            i.putExtra("details", details.getText());
            i.putExtra("komposisi", komposisi);
            view.getContext().startActivity(i);

        }
    }
}