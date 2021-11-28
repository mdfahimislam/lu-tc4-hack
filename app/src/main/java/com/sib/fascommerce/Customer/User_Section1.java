package com.sib.fascommerce.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User_Section1 extends AppCompatActivity {
    RecyclerView rco, rwo, rde, rho, rnu, rvi, rhe, rca, rdi, rpn, rme, rot, tip,RAll;
    TextView co, wo, de, ho, nu, vi, he, ca, dia, pn, me, ot, count, All;
    RelativeLayout scart;
    EditText se;
    SwipeRefreshLayout refresh;
    ImageView search, cart;
    Button add;
    List<ProductModel> list = new ArrayList<ProductModel>();
    List<ProductModel> list1 = new ArrayList<>();
    List<ProductModel> list2 = new ArrayList<>();
    List<ProductModel> list3 = new ArrayList<>();
    List<ProductModel> list4 = new ArrayList<>();
    List<ProductModel> list5 = new ArrayList<>();
    List<ProductModel> list6 = new ArrayList<>();
    List<ProductModel> list7 = new ArrayList<>();
    List<ProductModel> list8 = new ArrayList<>();
    List<ProductModel> list9 = new ArrayList<>();
    List<ProductModel> list10 = new ArrayList<>();
    List<ProductModel> list11 = new ArrayList<>();
    List<ProductModel> list12 = new ArrayList<>();
    List<ProductModel> list13 = new ArrayList<>();
    List<ProductModel> list14 = new ArrayList<>();
    List<ProductModel> list15 = new ArrayList<>();
    LinearLayout snack;
    ProAdapter m;
    BottomNavigationView bm;
    String email, email1 = "",url,name;
    int img[] = {R.drawable.accessories, R.drawable.education_type, R.drawable.furnitures, R.drawable.cosmetics, R.drawable.fashion, R.drawable.laptops, R.drawable.mobiles
            , R.drawable.running, R.drawable.sedan, R.drawable.pne, R.drawable.property, R.drawable.drugs, R.drawable.other};

    TipAdapter ta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_section);
        bm = (BottomNavigationView) findViewById(R.id.bottomnav);
        bm.setOnItemSelectedListener(item -> {
        /*    if (item.getItemId()==R.id.order) {
                onBackPressed();
            }  else if (item.getItemId() == R.id.orders) {
                startActivity(new Intent(User_Section.this, OrdersRe.class));
            }
            else if(item.getItemId()==R.id.fav)
            {
                startActivity(new Intent(User_Section.this, Favorite.class));
            }*/
            return true;
        });
        co = (TextView) findViewById(R.id.co);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        All = (TextView) findViewById(R.id.All);
        count = (TextView) findViewById(R.id.count);
        scart = (RelativeLayout) findViewById(R.id.scart);
        snack = (LinearLayout) findViewById(R.id.snack);
        se = (EditText) findViewById(R.id.se);
        search = (ImageView) findViewById(R.id.search);
        // cart = (ImageView) findViewById(R.id.cart);
        add = (Button) findViewById(R.id.add);
        SessionManager sh = new SessionManager(getApplicationContext(), SessionManager.USERSESSION);
        HashMap<String, String> hm = sh.returnData();
        email = hm.get(SessionManager.EMAIL);
        name = hm.get(SessionManager.FULLNAME);
        url = hm.get(SessionManager.URL);
        email1 = "";
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startActivity(new Intent(getApplicationContext(), User_Section1.class));
                finish();
            }
        });
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                break;
            email1 += email.charAt(i);
        }

        String na[] = getResources().getStringArray(R.array.What);
        wo = (TextView) findViewById(R.id.wo);
        de = (TextView) findViewById(R.id.de);
        ho = (TextView) findViewById(R.id.ho);
        nu = (TextView) findViewById(R.id.nu);
        ot = (TextView) findViewById(R.id.ot);
        pn = (TextView) findViewById(R.id.pn);
        he = (TextView) findViewById(R.id.he);
        ca = (TextView) findViewById(R.id.ca);
        vi = (TextView) findViewById(R.id.vi);
        me = (TextView) findViewById(R.id.me);
        dia = (TextView) findViewById(R.id.dia);
        rco = (RecyclerView) findViewById(R.id.rco);
        RAll = (RecyclerView) findViewById(R.id.RAll);
        tip = (RecyclerView) findViewById(R.id.tip);
        rhe = (RecyclerView) findViewById(R.id.rhe);
        rwo = (RecyclerView) findViewById(R.id.rwo);
        rde = (RecyclerView) findViewById(R.id.rde);
        rme = (RecyclerView) findViewById(R.id.rme);
        rho = (RecyclerView) findViewById(R.id.rho);
        rpn = (RecyclerView) findViewById(R.id.rpn);
        rnu = (RecyclerView) findViewById(R.id.rnu);
        rot = (RecyclerView) findViewById(R.id.rot);
        rca = (RecyclerView) findViewById(R.id.rca);
        rvi = (RecyclerView) findViewById(R.id.rvi);
        rdi = (RecyclerView) findViewById(R.id.rdi);
        ta = new TipAdapter(User_Section1.this, img, na);
        tip.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        tip.setAdapter(ta);



        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(co.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list.add(me);
                    }
                    rco.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list,"Us");
                    rco.setAdapter(m);
                } else {
                    co.setVisibility(View.GONE);
                    rco.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(wo.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list1.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list1.add(me);
                    }
                    rwo.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list1,"Us");
                    rwo.setAdapter(m);
                } else {
                    rwo.setVisibility(View.GONE);
                    wo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(de.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list2.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list2.add(me);
                    }
                    rde.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list2,"Us");
                    rde.setAdapter(m);
                } else {
                    rde.setVisibility(View.GONE);
                    de.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(ho.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list3.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list3.add(me);
                    }
                    rho.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list2,"Us");
                    rho.setAdapter(m);
                } else {
                    ho.setVisibility(View.GONE);
                    rho.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(nu.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list4.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list4.add(me);
                    }
                    rnu.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list4,"Us");
                    rnu.setAdapter(m);
                } else {
                    nu.setVisibility(View.GONE);
                    rnu.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(vi.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list5.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list5.add(me);
                    }
                    rvi.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list5,"Us");
                    rvi.setAdapter(m);
                } else {
                    vi.setVisibility(View.GONE);
                    rvi.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(he.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list6.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list6.add(me);
                    }
                    rhe.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list6,"Us");
                    rhe.setAdapter(m);
                } else {
                    he.setVisibility(View.GONE);
                    rhe.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(ca.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list7.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list7.add(me);
                    }
                    rca.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list7,"Us");
                    rca.setAdapter(m);
                } else {
                    ca.setVisibility(View.GONE);
                    rca.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(dia.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list8.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list8.add(me);
                    }
                    rdi.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list8,"Us");
                    rdi.setAdapter(m);
                } else {
                    dia.setVisibility(View.GONE);
                    rdi.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(pn.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list9.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list9.add(me);
                    }
                    rpn.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list9,"Us");
                    rpn.setAdapter(m);
                } else {
                    pn.setVisibility(View.GONE);
                    rpn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(me.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list10.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list10.add(me);
                    }
                    rme.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list10,"Us");
                    rme.setAdapter(m);
                } else {
                    me.setVisibility(View.GONE);
                    rme.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("AllProductsCategory").child(ot.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list11.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list11.add(me);
                    }
                    rot.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list11,"Us");
                    rot.setAdapter(m);
                } else {
                    ot.setVisibility(View.GONE);
                    rot.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ShowResults.class).putExtra("Re", se.getText().toString()));
            }
        });

        FirebaseDatabase.getInstance().getReference("AllProducts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    list15.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        ProductModel me = ds.getValue(ProductModel.class);
                        list15.add(me);
                    }
                    RAll.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                    m = new ProAdapter(User_Section1.this, list15,"Us");
                    RAll.setAdapter(m);
                } else {
                    RAll.setVisibility(View.GONE);
                    All.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

   /* @Override
   /* public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
    }*/
}