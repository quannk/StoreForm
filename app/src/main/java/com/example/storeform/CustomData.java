package com.example.storeform;

import com.example.storeform.model.enity.CategoryItem;
import com.example.storeform.model.enity.StoreItem;

import java.util.List;

public class CustomData {
    private static CustomData instance ;

    public static void addDataStore(List<StoreItem> storeItemList ) {

        storeItemList.add(new StoreItem("Bún khô","","35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô","","35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô","","35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô","","35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
        storeItemList.add(new StoreItem("Bún khô","","35.000", "Bắc Kạn", "Nông nghiệp Bắc Kạn"));
    }

    public static void addDataCategogy(List<CategoryItem> storeItemList ) {

        storeItemList.add(new CategoryItem("Danh mục sản phẩn", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("Bán và Mua", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("International", R.drawable.ic_vegan));
        storeItemList.add(new CategoryItem("Thẻ Thành viên", R.drawable.ic_vegan));

    }



    public static CustomData getInstance() {
        if (instance ==null) instance = new CustomData();
        return instance;
    }
}
