package com.sib.fascommerce.Customer;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sib.fascommerce.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.io.File;
import java.util.ArrayList;

public class Slider2 extends SliderViewAdapter<Slider2.Holder> {

    ArrayList<Uri> images;
    Context c;

    public Slider2(Context c, ArrayList<Uri> images){

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
        Toast.makeText(c,images.get(i)+"",Toast.LENGTH_LONG).show();
        try{

            Glide.with(c).load(images.get(i)).into(holder.imageView);
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
