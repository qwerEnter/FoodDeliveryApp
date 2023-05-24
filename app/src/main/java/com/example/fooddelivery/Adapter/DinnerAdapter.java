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
import com.example.fooddelivery.Model.DinnerModel;
import com.example.fooddelivery.R;

import java.util.List;

public class DinnerAdapter extends RecyclerView.Adapter<DinnerAdapter.ViewHolder> {

    private Context context;
    private List<DinnerModel> DinnerModelList;

    public DinnerAdapter(Context context, List<DinnerModel> dinnerModelList) {
        this.context = context;
        DinnerModelList = dinnerModelList;
    }

    @NonNull
    @Override
    public DinnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dinner_item,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull DinnerAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(DinnerModelList.get(position).getImg()).into(holder.img);
        holder.name.setText(DinnerModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return DinnerModelList.size();
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