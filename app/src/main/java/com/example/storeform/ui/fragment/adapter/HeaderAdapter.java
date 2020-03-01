package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.ItemHeaderTypeBinding;
import com.example.storeform.model.enity.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    public HeaderAdapter(Context context) {
        this.context = context;
    }

    public void setListItem(List<CategoryItem> categoryItemList) {
        this.categoryItemList.clear();
        this.categoryItemList = categoryItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHeaderTypeBinding itemHeaderTypeBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_header_type, parent, false);
        return new HeaderAdapter.HeaderItemViewHolder(itemHeaderTypeBinding.getRoot(), itemHeaderTypeBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((HeaderItemViewHolder) holder).setData(position);
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    private class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        ItemHeaderTypeBinding binding;

        public HeaderItemViewHolder(View root, ItemHeaderTypeBinding itemHeaderTypeBinding) {

            super(root);
            this.binding = itemHeaderTypeBinding;
        }

        public void setData(int position) {
            CategoryItem categoryItem = categoryItemList.get(position);
            if (categoryItem == null) return;
            if (categoryItem.getImgResouce() != -1)
                binding.imgAvatar.setImageResource(categoryItem.getImgResouce());
            if (categoryItem.getName() != null)
                binding.tvUserName.setText(categoryItem.getName());


        }
    }
}
