package com.example.aicloset;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<List<String>> dataList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView contents1;
        public TextView contents2;
        public TextView contents3;

        public MyViewHolder(View itemView) {
            super(itemView);
            contents1 = itemView.findViewById(R.id.contents1);
            contents2 = itemView.findViewById(R.id.contents2);
            contents3 = itemView.findViewById(R.id.contents3);
        }
    }

    public MyAdapter(List<List<String>> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<String> data = dataList.get(position);
        holder.contents1.setText(data.get(0));
        holder.contents2.setText(data.get(1));
        holder.contents3.setText(data.get(2));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

