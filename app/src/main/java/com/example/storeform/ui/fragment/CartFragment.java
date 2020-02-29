package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.storeform.R;
import com.example.storeform.databinding.CartFragmentBinding;

public class CartFragment extends Fragment {
    private static CartFragment instance;
    private CartFragmentBinding binding;

    public static CartFragment newInstance(String s, String s1) {
        if (instance == null)
            instance = new CartFragment();
        return instance;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.cart_fragment, container, false);
        return binding.getRoot();
    }
}
