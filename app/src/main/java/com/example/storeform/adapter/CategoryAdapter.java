package com.example.storeform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.CategoryItemBinding;
import com.example.storeform.model.CategoryItem;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList ;

    public CategoryAdapter(Context context) {
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
        CategoryItemBinding categoryItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.category_item, parent, false);
        return new CategoryItemViewHolder(categoryItemBinding.getRoot(), categoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        public CategoryItemViewHolder(View root, CategoryItemBinding categoryItemBinding) {

            super(root);
        }
    }
}
