package com.example.storeform.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.CustomData;
import com.example.storeform.R;
import com.example.storeform.control.viewmodel.HomeViewModel;
import com.example.storeform.databinding.FragmentHomeStoreBinding;
import com.example.storeform.model.enity.CategoryItem;
import com.example.storeform.model.enity.StoreItem;
import com.example.storeform.ui.fragment.adapter.CategoryAdapter;
import com.example.storeform.ui.fragment.adapter.FastCategoryAdapter;
import com.example.storeform.ui.fragment.adapter.HeaderAdapter;
import com.example.storeform.ui.fragment.adapter.MyStoreAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static HomeFragment instance;
    private HomeViewModel homeViewModel;
    private CategoryAdapter categoryAdapter;
    private HeaderAdapter headerAdapter;
    private FastCategoryAdapter fastCategoryAdapter;
    private MyStoreAdapter myStoreAdapter;

    private List<CategoryItem> listCategory;
    private List<CategoryItem> listStore;
    private RecyclerView rcvHeader;
    FragmentHomeStoreBinding mBinding;
    private List<StoreItem> listStoreTopItem;

    public static HomeFragment newInstance(String s, String s1) {
        if (instance== null) instance = new HomeFragment();
        return instance;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        initViewModer();
        mBinding=  DataBindingUtil.inflate(inflater, R.layout.fragment_home_store, container, false);
        initView();
        initAdapter();
        return mBinding.getRoot();
    }

    private void initView() {
        mBinding.layoutFastCategory.vegetableItem.ivTopImage.setImageResource(R.drawable.ic_fruit);
        mBinding.layoutFastCategory.vegetableItem.tvTitle.setText(R.string.tv_vegetable);
        mBinding.layoutFastCategory.vegetableItem.getRoot().setOnClickListener(clickCategoryItemListenner);

        mBinding.layoutFastCategory.chickenItem.ivTopImage.setImageResource(R.drawable.ic_chicken);
        mBinding.layoutFastCategory.chickenItem.tvTitle.setText(R.string.tv_meat);
        mBinding.layoutFastCategory.chickenItem.getRoot().setOnClickListener(clickCategoryItemListenner);


        mBinding.layoutFastCategory.drinkItem.ivTopImage.setImageResource(R.drawable.ic_water);
        mBinding.layoutFastCategory.drinkItem.tvTitle.setText(R.string.tv_drink);
        mBinding.layoutFastCategory.drinkItem.getRoot().setOnClickListener(clickCategoryItemListenner);


        mBinding.layoutFastCategory.saltItem.ivTopImage.setImageResource(R.drawable.ic_salt);
        mBinding.layoutFastCategory.saltItem.tvTitle.setText(R.string.tv_salt);
        mBinding.layoutFastCategory.saltItem.getRoot().setOnClickListener(clickCategoryItemListenner);


    }

    private void initViewModer() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    private void initAdapter() {
        getData();
        headerAdapter = new HeaderAdapter(this.getContext());
        headerAdapter.setListItem(listStore);
        mBinding.layoutTopNews.rcvNewsList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutTopNews.rcvNewsList.setAdapter(headerAdapter);

        categoryAdapter = new CategoryAdapter(this.getContext());
        categoryAdapter.setCategoryItemList(listCategory);
        mBinding.layoutCategory.rcvNewsList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutCategory.rcvNewsList.setAdapter(categoryAdapter);

        fastCategoryAdapter = new FastCategoryAdapter(this.getContext());
        fastCategoryAdapter.setCategoryItemList(listCategory);
        mBinding.layoutFastCategory.rcvNewsList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutFastCategory.rcvNewsList.setAdapter(fastCategoryAdapter);

        myStoreAdapter = new MyStoreAdapter(this.getContext());
        myStoreAdapter.setCategoryItemList(listStoreTopItem);
        mBinding.layoutMyStore.rcvMyStore.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutMyStore.rcvMyStore.setAdapter(myStoreAdapter);

        mBinding.layoutMyStore.rcvMyStoreVegetable.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutMyStore.rcvMyStoreVegetable.setAdapter(myStoreAdapter);

        mBinding.layoutMyStore.rcvMyStoreMeat.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mBinding.layoutMyStore.rcvMyStoreMeat.setAdapter(myStoreAdapter);

    }

    private void getData() {
        // cho nay doc data tu file, tam thời thế đã
        homeViewModel.getCategoryItem();
        listStoreTopItem = new ArrayList<>();
        CustomData.getInstance().addDataStore(listStoreTopItem);
        listStore = new ArrayList<>();
        CustomData.getInstance().addDataCategogy(listStore);


    }

    private View.OnClickListener clickCategoryItemListenner= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };




}