package com.sib.fascommerce.Seller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;

import org.w3c.dom.Text;

import java.util.List;

public class ExpiredItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ProductModel> models;
    public ExpiredItemAdapter(List<ProductModel> models) {
        this.models=models;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.expireditem,parent,false)) {

        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView imageView=holder.itemView.findViewById(R.id.imageItem);
        TextView title = holder.itemView.findViewById(R.id.itemTitle);
        TextView des = holder.itemView.findViewById(R.id.desEX);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
