package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.storeform.R;
import com.example.storeform.databinding.SmsFragmentBinding;

public class SmsFragment extends Fragment {
    private static SmsFragment instance;
    private SmsFragmentBinding binding;

    public static SmsFragment newInstance(String s, String s1) {
        if (instance == null)
            instance = new SmsFragment();
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sms_fragment, container, false);
        return binding.getRoot();
    }
}
