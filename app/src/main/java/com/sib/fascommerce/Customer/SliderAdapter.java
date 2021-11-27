package com.sib.fascommerce.Customer;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sib.fascommerce.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.io.File;
import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    ArrayList<String> images;
    Context c;

    public SliderAdapter(Context c, ArrayList<String> images){

        this.images = images;
        this.c=c;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imageslider,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {

        try{
            Uri uri = Uri.fromFile(new File(images.get(i)));
            Glide.with(c).load(uri).into(holder.imageView);
        }catch (Exception e){

        }
      }

    @Override
    public int getCount() {
        return images.size();
    }

    public class Holder extends  SliderViewAdapter.ViewHolder{

        ImageView imageView;

        public Holder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);

        }
    }

}
