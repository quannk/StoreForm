package com.example.storeform.base;



import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "User")
public class User implements Serializable {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    public String id;


    @SerializedName(value = "user_name", alternate = {"username"})
    @Expose
    @ColumnInfo(name = "username")
    public String username;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @SerializedName("full_name")
    @Expose
    @ColumnInfo(name = "fullname")
    public String fullname;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @SerializedName("avatar")
    @Expose
    @ColumnInfo(name = "avatar")
    public String avatar="";

    @SerializedName("address")
    @Expose
    @ColumnInfo(name = "address")
    public String address;

    @SerializedName("city")
    @Expose
    @ColumnInfo(name = "city")
    public String city;

    @SerializedName("user_id")
    @Expose
    @ColumnInfo(name = "userId")
    public String userId;

    @SerializedName("role")
    @Expose
    @ColumnInfo(name = "role")
    public String role;

    @SerializedName("follow")
    @Expose
    @ColumnInfo(name = "follow")
    public int follow;

    @SerializedName("is_follow")
    @Expose
    @ColumnInfo(name = "isWidgetFollow")
    public int isFollow;

    @SerializedName("total_follow")
    @Expose
    @ColumnInfo(name = "totalFollow")
    public int totalFollow;

    @SerializedName("type")
    @Expose
    @ColumnInfo(name = "type")
    public int type;

    @SerializedName("channel_id")
    @Expose
    @ColumnInfo(name = "channel_id")
    public int chanelId;

    @SerializedName(value = "verifyAccount", alternate = {"verify_status"})
    @Expose
    @ColumnInfo(name = "verifyAccount")
    public boolean verifyAccount;

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "email")
    public String email;

    @SerializedName("phone")
    @Expose
    @ColumnInfo(name = "phone")
    public String phone;

    @SerializedName("lotuser_type")
    @Expose
    @ColumnInfo(name = "lotuser_type")
    public int lotus_type = 0;
    @SerializedName("lotuser_image")
    @Expose
    @ColumnInfo(name = "lotuser_image")
    public String lotus_image = "";


    public User() {
    }

    protected User(Parcel in) {
        id = in.readString();
        username = in.readString();
        fullname = in.readString();
        avatar = in.readString();
        address = in.readString();
        city = in.readString();
        userId = in.readString();
        role = in.readString();
        follow = in.readInt();
        isFollow = in.readInt();
        totalFollow = in.readInt();
        type = in.readInt();
    }


    public int getLotus_type() {
        return lotus_type;
    }

    public void setLotus_type(int lotus_type) {
        this.lotus_type = lotus_type;
    }

    public String getLotus_image() {
        return lotus_image==null? "":lotus_image;
    }

    public void setLotus_image(String lotus_image) {
        this.lotus_image = lotus_image;
    }
}
