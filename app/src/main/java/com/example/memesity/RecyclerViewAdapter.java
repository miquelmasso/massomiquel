package com.example.memesity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memesity.DB.MemesDBHelper;
import com.example.memesity.Models.Memes;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Memes> array_memes;
    private MemesDBHelper dbHelper;
    private SQLiteDatabase db;
    private Fragment fragment;

    public RecyclerViewAdapter(ArrayList<Memes> arrM){
        array_memes = arrM;
    }

    public interface RecyclerViewClickListener {
        public void recyclerViewListClicked(View v, int position);
    }

    public RecyclerViewAdapter(Fragment fragment, MemesDBHelper dbHelper, SQLiteDatabase db, ArrayList<Memes> arrM) {
        this.fragment =fragment; //all values here to connect with fragment
        this.dbHelper = dbHelper;
        this.db = db;
        array_memes = arrM;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.userName.setText(array_memes.get(position).getNom_usuari());
        holder.Description.setText(array_memes.get(position).getDescripcio());
    }


    @Override
    public int getItemCount() {
        return array_memes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{ //view holder model
        TextView userName;
        TextView Description;
        ImageView icon_user;
        ImageView postImage;

        public ViewHolder(@NonNull View view) {
            super(view);
            userName = view.findViewById(R.id.userName);
            Description = view.findViewById(R.id.Description);
            icon_user = view.findViewById(R.id.icon_user);
            postImage = view.findViewById(R.id.postImage);
        }
    }
}