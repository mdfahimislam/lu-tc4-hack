package com.sib.fascommerce.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sib.fascommerce.R;
import com.sib.fascommerce.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {
private ActivityNotificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}