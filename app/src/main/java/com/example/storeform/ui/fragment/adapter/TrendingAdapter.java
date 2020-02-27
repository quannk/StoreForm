package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.databinding.CategoryItemBinding;
import com.example.storeform.model.enity.StoreItem;

import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends BaseAdapter{
    private Context context;
    private List<StoreItem> listItem = new ArrayList<>();


    public TrendingAdapter(Context context) {
        this.context = context;
    }

    public void setListItem(List<StoreItem> listItem) {
        this.listItem.clear();
        this.listItem = listItem;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StoreItem storeItem = listItem.get(position);
        CategoryItemBinding categoryItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.store_item, parent, false);

        // set text các thứ ở đây
        return convertView;
    }

    private class TrendingItemViewHolder extends RecyclerView.ViewHolder {
        public TrendingItemViewHolder(View root, CategoryItemBinding categoryItemBinding) {

            super(root);
        }
    }
}
