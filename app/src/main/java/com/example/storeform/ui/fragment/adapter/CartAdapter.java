package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.ItemCartBinding;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> categoryItemList = new ArrayList<>();

    public CartAdapter(Context context) {
        this.context = context;
    }

    public void setCartItemList(List<String> categoryItemList) {
        this.categoryItemList.clear();
        this.categoryItemList = categoryItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding categoryItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_cart, parent, false);
        return new CartItemViewHolder(categoryItemBinding.getRoot(), categoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class CartItemViewHolder extends RecyclerView.ViewHolder {
        public CartItemViewHolder(View root, ItemCartBinding categoryItemBinding) {

            super(root);
        }
    }
}
