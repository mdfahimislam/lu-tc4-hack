package com.sib.fascommerce.Customer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrShow extends AppCompatActivity {
    String re1;
    TextView re;
    RecyclerView rere;
    ProAdapter ad;
    String[] ty=new String [5];
    int re3=0;
    RecyclerView gr;
    String email,email1="",url,name;
    ProAdapter agr;
    List<Pro> list=new ArrayList<>();
    List<Pro> list1=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tr_show);
        re=(TextView) findViewById(R.id.re);
        gr=(RecyclerView) findViewById(R.id.grid);
        rere=(RecyclerView) findViewById(R.id.rere);
        re1=getIntent().getStringExtra("Re");
        SessionManager sh = new SessionManager(getApplicationContext(), SessionManager.USERSESSION);
        HashMap<String, String> hm = sh.returnData();
        email = hm.get(SessionManager.EMAIL);
        name = hm.get(SessionManager.FULLNAME);
        email1 = "";
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                break;
            email1 += email.charAt(i);
        }

        rere.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ad=new ProAdapter(TrShow.this,list1,"Sh");
        rere.setAdapter(ad);
        re.setText("Showing results for "+re1);
        FirebaseDatabase.getInstance().getReference("AllProicines").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1.clear();
                for(DataSnapshot s:snapshot.getChildren())
                {
                    Pro de=s.getValue(Pro.class);
                    re1=re1.toLowerCase();

                    String n=de.getDisease().toLowerCase();
                //    Toast.makeText(getApplicationContext(),n+" "+re1,Toast.LENGTH_LONG).show();
                    if(n.contains(re1)||n.equals(re1)||re1.contains(n)) {
                        list1.add(de);
                    }
                }
                ad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ty[0]="Vitamins";
        ty[1]="Penumonia";
        re3=2;
        gr.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        agr=new ProAdapter(TrShow.this,list,"Us");
        gr.setAdapter(agr);
        for(int i=0;i<re3;i++) {

            FirebaseDatabase.getInstance().getReference("Proicines").child(ty[i]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot s : snapshot.getChildren()) {
                        Pro de = s.getValue(Pro.class);
                        list.add(de);
                    }
                    agr.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}