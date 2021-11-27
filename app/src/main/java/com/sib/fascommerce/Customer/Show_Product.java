package com.sib.fascommerce.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.DataModels.BidModel;
import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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


    String pid,title,Des,Ran,price,pri,cat;



    List<ProductModel> list=new ArrayList<>();
    List<BidModel> list1=new ArrayList<>();

  //ArrayList<String> images={"R.drawable.afganistan", "R.drawable.ba"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        title=getIntent().getStringExtra("Mname");
        Des=getIntent().getStringExtra("Des");
        Ran=getIntent().getStringExtra("Ran");
        pri=getIntent().getStringExtra("Price");
        cat=getIntent().getStringExtra("Dis");
//        /Url=getIntent().getStringExtra("Url");
        bi=(Button) findViewById(R.id.bi);
        search=(ImageView) findViewById(R.id.search);
        gon=(LinearLayout) findViewById(R.id.gon);
        enter=(EditText)findViewById(R.id.enter);
        mname=(TextView) findViewById(R.id.mname);
        price1=(TextView) findViewById(R.id.price);
        model=(TextView) findViewById(R.id.model);
        mname.setText(title);
        des.setText(Des);
        con.setText("New");
        price1.setText(pri);
        model.setText(cat);

        con=(TextView) findViewById(R.id.con);
        bidRange=(TextView) findViewById(R.id.bidRange);
        model=(TextView) findViewById(R.id.model);
        des=(TextView) findViewById(R.id.des);
        name=(TextView) findViewById(R.id.name);
        bprofile=(CircleImageView) findViewById(R.id.bprofile);
        grid=(RecyclerView) findViewById(R.id.grid);
        bids=(RecyclerView) findViewById(R.id.bids);
        /*SliderAdapter sliderAdapter = new SliderAdapter(Show_Product.this,images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();*/
        grid.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        agr=new ProAdapter(Show_Product.this,list,"Us");
        grid.setAdapter(agr);

        bids.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        ba=new BidAdapter(Show_Product.this,list1);
        bids.setAdapter(ba);

        FirebaseDatabase.getInstance().getReference("AllProductsBids").child(pid).child("Bids").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren())
                {
                    int k=0;
                    for(DataSnapshot s: snapshot.getChildren())
                    {
                        if(k==3)
                            break;

                        BidModel b=s.getValue(BidModel.class);

                        list1.add(b);

                    }

                    ba.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bi.setVisibility(View.GONE);
                gon.setVisibility(View.VISIBLE);



            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager sh = new SessionManager(getApplicationContext(), SessionManager.USERSESSION);
                hm = sh.returnData();
                email = hm.get(SessionManager.EMAIL);
                url = hm.get(SessionManager.URL);
                token = hm.get(SessionManager.TOKEN);
                points = hm.get(SessionManager.POINTS);
                phone = hm.get(SessionManager.PHONE);
                name1= hm.get(SessionManager.FULLNAME);
               String uid= hm.get(SessionManager.UID);
                BidModel bid=new BidModel(Integer.parseInt(enter.getText().toString()),Integer.parseInt(points),phone, email,name1,url,uid,Ran,"true");
                FirebaseDatabase.getInstance().getReference(uid).child("Bids").child(pid).setValue(bid);
                FirebaseDatabase.getInstance().getReference("AllProducts").child(pid).child("Bids").setValue(bid);

            }
        });
        








    }
}