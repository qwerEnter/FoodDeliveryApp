package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.ManageOrder.OrderActivity;
import com.example.fooddelivery.Model.AllMenuModel;
import com.example.fooddelivery.R;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.ViewHolder> {

    private Context context;
    private List<AllMenuModel> AllMenuModelList;

    public AllMenuAdapter(Context context, List<AllMenuModel> allmenuModelList) {
        this.context = context;
        AllMenuModelList = allmenuModelList;
    }

    @NonNull
    @Override
    public AllMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.allmenus,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(AllMenuModelList.get(position).getImg()).into(holder.img);
        holder.name.setText(AllMenuModelList.get(position).getName());
        holder.price.setText(AllMenuModelList.get(position).getPrice()+"  MYR");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("detail",AllMenuModelList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return AllMenuModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.pop_img);
            name = itemView.findViewById(R.id.pop_name);
            price = itemView.findViewById(R.id.pop_price);


        }
    }
}