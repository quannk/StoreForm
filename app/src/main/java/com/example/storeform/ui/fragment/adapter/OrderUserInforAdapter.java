package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.ItemOrderStatusBinding;

import java.util.ArrayList;
import java.util.List;

public class OrderUserInforAdapter extends RecyclerView.Adapter<OrderUserInforAdapter.ProfileManagerVH> {

    private List<String> listProfileManager = new ArrayList<>();
    private Context context;

    public OrderUserInforAdapter(List<String> listProfileManager, Context context) {
        this.listProfileManager = listProfileManager;
        this.context = context;
    }

    @NonNull
    @Override
    public ProfileManagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrderStatusBinding itemOrderStatusBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_order_status, parent, false);
        return new OrderUserInforAdapter.ProfileManagerVH(itemOrderStatusBinding.getRoot(), itemOrderStatusBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileManagerVH holder, int position) {
        ((OrderUserInforAdapter.ProfileManagerVH) holder).setData(position);
    }

    @Override
    public int getItemCount() {
//        if (listProfileManager != null)
//            return listProfileManager.size();
//        else return 0;
        return 10;
    }

    public class ProfileManagerVH extends RecyclerView.ViewHolder {
        ItemOrderStatusBinding binding;

        public ProfileManagerVH(View root, ItemOrderStatusBinding itemProfileManagerBinding) {
            super(root);
            binding = itemProfileManagerBinding;
        }

        public void setData(int position) {

        }
    }
}