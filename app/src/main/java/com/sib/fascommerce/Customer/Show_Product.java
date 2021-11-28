package com.sib.fascommerce.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.DataModels.BidModel;
import com.sib.fascommerce.DataModels.BidO;
import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Show_Product extends AppCompatActivity {
    SliderView sliderView;
    Button bi;
    EditText enter;
    TextView mname,con,bidRange,model,des,name,price1;
    CircleImageView bprofile;
    ProAdapter agr;
    ImageView search;
   LinearLayout gon;
    HashMap<String, String> hm;
    String email,phone,points,url,token,name1;
    BidAdapter ba;
    RecyclerView grid,bids;


    String pid,title,Des,Ran,price,pri,cat,pUrl,na;



    List<ProductModel> list=new ArrayList<>();
    List<BidO> list1=new ArrayList<>();

  ArrayList<Uri> images=new ArrayList<android.net.Uri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
try {
    pid=getIntent().getStringExtra("Id");
    na=getIntent().getStringExtra("Uid");
    name=(TextView) findViewById(R.id.name);
    con=(TextView) findViewById(R.id.con);
    bi=(Button) findViewById(R.id.bi);
    model=(TextView) findViewById(R.id.model);
    bidRange=(TextView) findViewById(R.id.bidRange);
    mname=(TextView) findViewById(R.id.mname);
    des=(TextView) findViewById(R.id.des);
    // pri = getIntent().getStringExtra("Price");
  //  cat = getIntent().getStringExtra("Dis");
   // gon=(LinearLayout)findViewById(R.id.gon);
//        /Url=getIntent().getStringExtra("Url");
Toast.makeText(getApplicationContext(),pid+"",Toast.LENGTH_LONG).show();
    bprofile = (CircleImageView) findViewById(R.id.bprofile);
    grid = (RecyclerView) findViewById(R.id.grid);
    bids = (RecyclerView) findViewById(R.id.bids);
    FirebaseDatabase.getInstance().getReference("AllProducts").child(pid).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot s) {
            if(s.hasChildren()) {
               int bs=s.child("basePrice").getValue(Integer.class);
                    des.setText(s.child("des").getValue(String.class));
                    bidRange.setText("Base Price: "+bs+"");
                    pri=bs+"";
                   mname.setText(s.child("title").getValue(String.class));
                   model.setText("Category: "+s.child("category").getValue(String.class));
                   con.setText("Condition: New");
                    Toast.makeText(getApplicationContext(),"Abid34",Toast.LENGTH_LONG).show();

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Abid",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
name.setText(na);
    grid.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

    agr = new ProAdapter(Show_Product.this, list, "Us");
    grid.setAdapter(agr);

    bids.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    ba = new BidAdapter(Show_Product.this, list1);
    bids.setAdapter(ba);
try {

    FirebaseDatabase.getInstance().getReference("AllProductsBids").child(pid).child("Bids").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot s : snapshot.getChildren()) {


                    BidO b3 = s.getValue(BidO.class);


                    list1.add(b3);


            }
            ba.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
}
catch(Exception e)
{
    Log.d("TAG",e.getMessage());
}

    bi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Bid.class).putExtra("Pr",pri).putExtra("PID",pid));
            finish();



        }
    });


    for (int i = 0; i < 3; i++) {

        FirebaseStorage.getInstance().getReference(pUrl).child(pUrl + i).getDownloadUrl().addOnSuccessListener(uri -> {
            images.add(uri);
            //   Toast.makeText(getApplicationContext(),uri+"",Toast.LENGTH_LONG).show();

        });
    }
    Slider2 sliderAdapter = new Slider2(Show_Product.this,images);

    sliderView.setSliderAdapter(sliderAdapter);
    sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
    sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
    sliderView.startAutoCycle();
}
catch(Exception e)
{
    Log.d("TAG",e.getMessage());
}







    }
}