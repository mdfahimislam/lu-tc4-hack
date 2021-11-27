package com.sib.fascommerce.Seller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.sib.fascommerce.Fragments.ExpiredFragment;
import com.sib.fascommerce.Fragments.SoldFragments;
import com.sib.fascommerce.Fragments.onGoingFragments;
import com.sib.fascommerce.R;
import com.sib.fascommerce.databinding.ActivityProductListBinding;

public class ProductListActivity extends AppCompatActivity {
private ActivityProductListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new ExpiredFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
           Fragment fragment = null;

           switch (item.getItemId())
           {
               case R.id.onGoingMenu:
                   fragment=new onGoingFragments();
                   break;
               case R.id.soldMenu:
                   fragment=new SoldFragments();
                   break;
               case R.id.expiredMenu:
                   fragment=new ExpiredFragment();
                   break;
           }

            return loadFragment(fragment);
        });


    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}