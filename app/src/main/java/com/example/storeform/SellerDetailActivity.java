package com.example.storeform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.example.storeform.BaseActivity;
import com.example.storeform.R;
import com.example.storeform.databinding.ActivityDetailSellerBinding;
import com.example.storeform.ui.fragment.adapter.SellerDetailAdapter;
import com.google.android.material.tabs.TabLayout;

public class SellerDetailActivity extends BaseActivity {
    private ActivityDetailSellerBinding binding;
    private SellerDetailAdapter sellerDetailAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, SellerDetailActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_seller);

        initVIew();

    }

    private void initVIew() {
        sellerDetailAdapter = new SellerDetailAdapter(SellerDetailActivity.this, getSupportFragmentManager(), 3);
        ViewPager pager = binding.layoutDetailSeller.pager;
        pager.setAdapter(sellerDetailAdapter);
        TabLayout tabs = binding.layoutDetailSeller.tabLayout;
        tabs.setupWithViewPager(pager);
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
}
