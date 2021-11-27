package com.sib.fascommerce.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sib.fascommerce.R;
import com.sib.fascommerce.databinding.FragmentExpiredBinding;

public class ExpiredFragment extends Fragment {
private FragmentExpiredBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentExpiredBinding.inflate(getLayoutInflater());








        return binding.getRoot();
    }
}