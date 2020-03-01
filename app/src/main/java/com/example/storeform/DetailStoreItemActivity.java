package com.example.storeform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.storeform.databinding.ActivityDetailItemBinding;

public class DetailStoreItemActivity extends BaseActivity {
    private ActivityDetailItemBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, R.layout.activity_detail_item);
    }

    public static void start(Context context){
        Intent starter = new Intent(context, DetailStoreItemActivity.class);
        context.startActivity(starter);
    }
}
