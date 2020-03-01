package com.example.storeform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.storeform.databinding.ActivityDetailOrderManagerBinding;

public class DetailOrderManagerActivity extends BaseActivity {
    private static final String ORDER_MANAGER_TITLE = "ORDER_MANAGER_TITLE";
    private ActivityDetailOrderManagerBinding binding;
    private String title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_order_manager);

        if (getIntent() != null)
            title = getIntent().getStringExtra(ORDER_MANAGER_TITLE);
        binding.tvItemProlife.setText(title);

        initView();
    }

    private void initView() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public static void start(Context context, String title) {
        Intent starter = new Intent(context, DetailOrderManagerActivity.class);
        starter.putExtra(ORDER_MANAGER_TITLE, title);
        context.startActivity(starter);
    }

}
