package com.example.storeform.model;

public class UserInfor {
    private String title;
    private int iconResouce;

    public UserInfor(String title, int iconResouce) {
        this.title = title;
        this.iconResouce = iconResouce;
    }

    public String getTitle() {
        return title;
    }

    public int getIconResouce() {
        return iconResouce;
    }
}
