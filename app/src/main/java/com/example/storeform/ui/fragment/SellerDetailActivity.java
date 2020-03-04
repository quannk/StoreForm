package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.storeform.BaseActivity;
import com.example.storeform.R;
import com.example.storeform.databinding.ActivityDetailSellerBinding;
import com.google.android.material.tabs.TabLayout;

public class SellerDetailActivity extends BaseActivity {
    ActivityDetailSellerBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_detail_seller);

        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = (TabLayout) binding.layout;
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"));
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"));
        tabLayout.addTab(tabLayout.newTab().setText("Cooking"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Use PagerAdapter to manage page views in fragments.
    }
}
