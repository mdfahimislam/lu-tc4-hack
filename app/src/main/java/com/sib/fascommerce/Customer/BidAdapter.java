package com.sib.fascommerce.Customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.sib.fascommerce.DataModels.BidModel;
import com.sib.fascommerce.DataModels.BidO;
import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BidAdapter extends RecyclerView.Adapter<BidAdapter.AllBids>{
    List<BidO> list;
    Context c;
    String wo;
    public  BidAdapter(Context c, List<BidO> list){
        this.c=c;
        this.list=list;

    }
    @NonNull
    @Override
    public BidAdapter.AllBids onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bid, parent, false);
        return new AllBids(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BidAdapter.AllBids holder, int i) {

    /*  try{
            StorageReference storageReference= FirebaseStorage.getInstance().getReference(list.get(i).getUrl());
            //Glide.with(holder.itemView.getContext()).load(storageReference).into(imageView);
            storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                //  Toast.makeText(c, list.get(i).getURL(),Toast.LENGTH_LONG).show();

                try{
                    Glide.with(c.getApplicationContext()).load(uri).into(holder.profile);
                }
                catch (Exception e){

                }

            });}
        catch (Exception e){

        }*/
holder.points.setText(list.get(i).getPoints());
holder.name.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class AllBids extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView name,points,bid;
        public AllBids(@NonNull View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.profile);
            name=itemView.findViewById(R.id.name);
            points=itemView.findViewById(R.id.points);
            bid=itemView.findViewById(R.id.bid);
        }
    }
}
