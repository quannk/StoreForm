package com.example.storeform.base;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 * thaond
 * phone: 0349566858
 */
public class BaseStorage {
    private static BaseStorage instance;
    public float tokenAvailable = 0f;

    public static BaseStorage getInstance() {
        if (instance == null) {
            instance = new BaseStorage();
        }
        return instance;
    }

    public  User user;
    public String notiSocketVersion = "2.0.0";
    //width height man hinh load trong man splash
//    public int width, height;
//    public int feedThumbSize, feedLinkSize, frameThumbSize, frameLinkSize;
    public int width = 1080, height = 1920;
    public int feedThumbSize = 400, feedLinkSize = 1080, frameThumbSize = 200, frameLinkSize = 400;
    public int avatarThumbSize = 100, avatarLinkSize = 300;
    public String KeyChalleng_Dev = "8965ec0d-fd28-46f2-99e0-6f49d173f799";//dev
    public String KeyChalleng_Release = "52a28bfe-d627-440d-a2a7-ec84d369c3e1";//release
    public String KeyChalleng_Profile = "98d9eaac-f7de-4ade-b63e-223359230ab2";//release-dev
    public String KeyManageFolder = "EH8TciCHotTHBL0LR60s";//release
    GsonBuilder gsonBuilder;
    private Gson customGson;
    public List<String> listDomainThumb;
    public Integer[] uneditableCardType;


    public void clearData() {
        user = null;
        instance = null;
    }


}
