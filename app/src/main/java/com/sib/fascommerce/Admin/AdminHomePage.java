package com.sib.fascommerce.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.sib.fascommerce.R;

public class AdminHomePage extends AppCompatActivity {

    private LinearLayout statisticBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        statisticBtn = findViewById(R.id.admin_activity_statictis_Btn);


        statisticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomePage.this, AdminStatistic.class));
            }
        });
    }
}