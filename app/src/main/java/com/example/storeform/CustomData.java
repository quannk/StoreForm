package com.example.storeform;

import com.example.storeform.model.enity.CategoryItem;
import com.example.storeform.model.enity.StoreItem;

import java.util.List;

public class CustomData {
    private static CustomData instance;

    public static void addDataStore(List<StoreItem> storeItemList) {
        if (storeItemList.size() > 0) return;

        storeItemList.add(new StoreItem("Bún khô", "", "35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô", "", "35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô", "", "35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô", "", "35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô", "", "35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
    }

    public static void addDataCategogy(List<CategoryItem> storeItemList) {

        storeItemList.add(new CategoryItem("Danh mục sản phẩn", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("Bán và Mua", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("International", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("Thẻ Thành viên", R.drawable.ic_vegan));

    }


    public static CustomData getInstance() {
        if (instance == null) instance = new CustomData();
        return instance;
    }

    public static void addDataProfileManager(List<String> listProfileManager) {
        if (listProfileManager.size() > 0) return;
        listProfileManager.add("Quản lí đơn hàng");
        listProfileManager.add("Đơn đã tiếp nhận");
        listProfileManager.add("Đơn hàng chờ thanh toán lại");
        listProfileManager.add("Đơn hàng chờ vận chuyển");
        listProfileManager.add("Đơn hàng chờ thành công");
        listProfileManager.add("Đơn hàng chờ đã hủy");
    }

}
