package com.example.storeform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.storeform.databinding.ActivityOrderUserInforBinding;
import com.example.storeform.ui.fragment.adapter.OrderUserInforAdapter;

public class ListOrderUserInforActivity extends BaseActivity {
    private static final String ORDER_MANAGER_TITLE = "ORDER_MANAGER_TITLE";
    private ActivityOrderUserInforBinding binding;
    private OrderUserInforAdapter orderUserInforAdapter;
    private String title;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_user_infor);

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
        orderUserInforAdapter = new OrderUserInforAdapter(null,this);
        binding.rcvUserOrder.setLayoutManager(new LinearLayoutManager(null));
        binding.rcvUserOrder.setAdapter(orderUserInforAdapter);
    }


    public static void start(Context context, String title) {
        Intent starter = new Intent(context, ListOrderUserInforActivity.class);
        starter.putExtra(ORDER_MANAGER_TITLE, title);
        context.startActivity(starter);
    }

}
