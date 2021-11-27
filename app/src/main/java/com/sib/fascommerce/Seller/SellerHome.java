package com.sib.fascommerce.Seller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sib.fascommerce.Fragments.onGoingFragments;
import com.sib.fascommerce.R;

public class SellerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

    }

    public void goToAddNew(View view) {
        startActivity(new Intent(this,AddNewActivity.class));
    }

    public void goToProducts(View view) {
        startActivity(new Intent(this,ProductListActivity.class));
    }
}