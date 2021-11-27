package com.sib.fascommerce.Seller;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;

import java.util.List;

public class SoldAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ProductModel> models;
    public SoldAdapter(List<ProductModel> models) {
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

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
