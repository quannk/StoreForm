package com.example.storeform.ui.fragment.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment1;
import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment2;
import com.example.storeform.ui.fragment.adapter.seller.TabSellerFragment3;

public class SellerDetailPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SellerDetailPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TabSellerFragment1();
            case 1:
                return new TabSellerFragment2();
            case 2:
                return new TabSellerFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}