package com.sib.fascommerce.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.sib.fascommerce.R;

public class AdminHomePage extends AppCompatActivity {

    private LinearLayout statisticBtn;
    private LinearLayout customerRequestBtn;
    private LinearLayout sellerRequestBtn;
    private LinearLayout customerList;
    private LinearLayout sellerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);


        // Layout
        statisticBtn = findViewById(R.id.admin_activity_statictis_Btn);
        customerRequestBtn = findViewById(R.id.admin_panel_customer_request);
        sellerRequestBtn = findViewById(R.id.admin_panel_seller_request);
        customerList = findViewById(R.id.admin_panel_customer_list);
        sellerList = findViewById(R.id.admin_panel_seller_list);




        statisticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomePage.this, AdminStatistic.class));
            }
        });

        customerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CustomerList.class));
            }
        });

        customerRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CustomerRequest.class));
            }
        });

        sellerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SellerList.class));
            }
        });

        sellerRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SellerRequest.class));
            }
        });

    }
}