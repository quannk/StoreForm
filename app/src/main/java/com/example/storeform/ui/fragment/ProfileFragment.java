package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeform.CustomData;
import com.example.storeform.R;
import com.example.storeform.databinding.ProfileFragmentBinding;
import com.example.storeform.ui.fragment.adapter.ProfileManagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private static ProfileFragment instance;
    private ProfileFragmentBinding binding;
    private ProfileManagerAdapter profileManagerAdapter;
    private List<String> listProfileManager = new ArrayList<>();

    public static ProfileFragment newInstance(String s, String s1) {
        if (instance == null)
            instance = new ProfileFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        CustomData.addDataProfileManager(listProfileManager);
        profileManagerAdapter = new ProfileManagerAdapter(listProfileManager,getContext());
        binding.rcvProfileManager.setLayoutManager(new LinearLayoutManager(null));
        binding.rcvProfileManager.setAdapter(profileManagerAdapter);
    }

}
