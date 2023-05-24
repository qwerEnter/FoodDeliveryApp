package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.Model.BreakfastModel;
import com.example.fooddelivery.Model.RecommendModel;
import com.example.fooddelivery.R;

import java.util.List;

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder> {

    private Context context;
    private List<BreakfastModel> BreakfastModelList;

    public BreakfastAdapter(Context context, List<BreakfastModel> bekpesModelList) {
        this.context = context;
        BreakfastModelList = bekpesModelList;
    }

    @NonNull
    @Override
    public BreakfastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfast_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(BreakfastModelList.get(position).getImg()).into(holder.img);
        holder.name.setText(BreakfastModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return BreakfastModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.pop_img);
            name = itemView.findViewById(R.id.pop_name);



        }
    }
}