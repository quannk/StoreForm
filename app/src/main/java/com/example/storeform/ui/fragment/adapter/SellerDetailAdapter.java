package com.example.storeform.ui.fragment.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeform.ui.fragment.HomeFragment;
import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment1;
import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment2;
import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment3;

public class SellerDetailAdapter  extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    private String title;

    public SellerDetailAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabSellerFragment1 tabSellerFragment1 = new TabSellerFragment1();
                title = "Sản phẩm";
                return tabSellerFragment1;
            case 1:
                TabSellerFragment2 sportFragment = new TabSellerFragment2();
                title = "Giới thiệu";
                return sportFragment;
            case 2:
                TabSellerFragment3 movieFragment = new TabSellerFragment3();
                title = "Liên Hệ";
                return movieFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sản phẩm";
            case 1:
                return  "Giới thiệu";
            case 2:
                return  "Liên Hệ";
            default:
                return null;
        }
    }
}