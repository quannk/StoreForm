package com.example.storeform.model.enity;

public class CategoryItem {
    private String name;
    private int imgResouce;

    public CategoryItem(String name, int imgResouce) {
        this.name = name;
        this.imgResouce = imgResouce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResouce() {
        return imgResouce;
    }

    public void setImgResouce(int imgResouce) {
        this.imgResouce = imgResouce;
    }
}
