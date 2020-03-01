package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.CategoryFastItemBinding;
import com.example.storeform.databinding.CategoryItemBinding;
import com.example.storeform.model.enity.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class FastCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    public FastCategoryAdapter(Context context) {
        this.context = context;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList.clear();
        this.categoryItemList = categoryItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryFastItemBinding categoryFastItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.category_fast_item, parent, false);
        return new CategoryItemViewHolder(categoryFastItemBinding.getRoot(), categoryFastItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        public CategoryItemViewHolder(View root, CategoryFastItemBinding categoryItemBinding) {

            super(root);
        }
    }
}
