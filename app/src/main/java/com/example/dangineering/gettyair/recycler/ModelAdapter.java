package com.example.dangineering.gettyair.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dangineering.gettyair.R;
import com.example.dangineering.gettyair.network.respmodel.Image;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ItemHolder> {

    List<Image> data = new ArrayList<>();


    public void setData(List<Image> images) {
        data = images;
        notifyDataSetChanged();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Image i = data.get(position);
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
