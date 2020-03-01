package com.example.storeform.model.enity;

public class StoreItem {

    public String name;
    public String type;
    public String price;
    public String location;
    public String seller;

    public StoreItem(String name, String type, String price, String location, String seller) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.location = location;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
