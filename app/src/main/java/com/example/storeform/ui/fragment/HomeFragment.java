package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.R;
import com.example.storeform.adapter.CategoryAdapter;
import com.example.storeform.adapter.TrendingAdapter;
import com.example.storeform.databinding.FragmentHomeStoreBinding;
import com.example.storeform.model.CategoryItem;
import com.example.storeform.model.StoreItem;
import com.example.storeform.ui.control.HomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CategoryAdapter categoryAdapter;
    private TrendingAdapter trendingAdapter;

    private List<CategoryItem> listCategory;
    private List<StoreItem> listStore;
    private RecyclerView rcvHeader;
    FragmentHomeStoreBinding mBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        initViewModer();
        mBinding=  DataBindingUtil.inflate(inflater, R.layout.fragment_home_store, container, false);
        initView();
        initAdapter();
        return mBinding.getRoot();
    }

    private void initView() {

    }

    private void initViewModer() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    private void initAdapter() {
        getData();
        categoryAdapter = new CategoryAdapter(this.getContext());
        categoryAdapter.setCategoryItemList(listCategory);
        mBinding.layoutTopNews.rcvNewsList.setAdapter(categoryAdapter);


        trendingAdapter = new TrendingAdapter(this.getContext());
        trendingAdapter.setListItem(listStore);
        mBinding.layoutTrending.girdTrending.setAdapter(trendingAdapter);
    }

    private void getData() {
        // cho nay doc data tu file, tam thời thế đã
        homeViewModel.getCategoryItem();

    }


}