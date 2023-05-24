package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.Model.HistoryModel;
import com.example.fooddelivery.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    Context context;
    List<HistoryModel> historyModelList;

    public HistoryAdapter(Context context, List<HistoryModel> historyModelList) {
        this.context = context;
        this.historyModelList = historyModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycartitem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position)

    {

        holder.date.setText(historyModelList.get(position).getProductDate());
        holder.time.setText(historyModelList.get(position).getProductTime());
        holder.name.setText(historyModelList.get(position).getProductName());
        holder.quantity.setText(historyModelList.get(position).getProductQuantity());
        holder.price.setText(String.valueOf(historyModelList.get(position).getProductPrice()));
    }

    @Override
    public int getItemCount() {
        return historyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,price,date,time,quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.product_date);
            time = itemView.findViewById(R.id.product_time);
            name = itemView.findViewById(R.id.product_name);
            quantity = itemView.findViewById(R.id.product_quantity);
            price = itemView.findViewById(R.id.product_price);

        }
    }
}
