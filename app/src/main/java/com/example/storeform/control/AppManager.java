package com.example.storeform.control;

import android.content.Context;

public class AppManager {
    private static AppManager instance;
    public String apiType;

    public static AppManager getInstance(Context context) {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;

    }
}
