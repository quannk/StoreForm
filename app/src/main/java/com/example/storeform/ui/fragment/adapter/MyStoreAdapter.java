package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.CategoryItemBinding;
import com.example.storeform.databinding.StoreItemBinding;
import com.example.storeform.model.enity.StoreItem;

import java.util.ArrayList;
import java.util.List;

public class MyStoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<StoreItem> storeItemList = new ArrayList<>();

    public MyStoreAdapter(Context context) {
        this.context = context;
    }


    public void setCategoryItemList(List<StoreItem> storeItemList) {
        this.storeItemList.clear();
        this.storeItemList = storeItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StoreItemBinding  storeItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.store_item, parent, false);
        return new StoreItemViewHolder(storeItemBinding.getRoot(), storeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyStoreAdapter.StoreItemViewHolder) holder).setData(position);

    }

    @Override
    public int getItemCount() {
        return storeItemList.size();
    }

    private class StoreItemViewHolder extends RecyclerView.ViewHolder {
        StoreItemBinding binding ;

        public StoreItemViewHolder(View root, StoreItemBinding categoryItemBinding) {
            super(root);
            this.binding = categoryItemBinding;

        }

        public void setData(int pos) {
            StoreItem storeItem = storeItemList.get(pos);
            if (storeItem == null) return;
            if (storeItem.getName() != null)
                binding.tvTitle.setText(storeItem.getName());

            if (storeItem.getPrice() != null)
                binding.tvPrice.setText(storeItem.getPrice());

            if (storeItem.getLocation() != null)
                binding.tvLocate.setText(storeItem.getLocation());

            if (storeItem.getSeller() != null)
                binding.tvSeller.setText(storeItem.getSeller());

        }
    }
}
