package com.example.memesity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> array_noms;

    public RecyclerViewAdapter(ArrayList<String> arrN){
        array_noms = arrN;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText(array_noms.get(position));
    }

    @Override
    public int getItemCount() {
        return array_noms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        ImageView icon_user;
        ImageView post_image;

        public ViewHolder(@NonNull View view) {
            super(view);
            userName = view.findViewById(R.id.userName);
            icon_user = view.findViewById(R.id.icon_user);
            post_image = view.findViewById(R.id.postImage);
        }
    }
}