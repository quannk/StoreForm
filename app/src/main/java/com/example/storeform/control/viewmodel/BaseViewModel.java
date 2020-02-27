package com.example.storeform.control.viewmodel;

import android.os.Handler;

import androidx.lifecycle.ViewModel;

import com.example.storeform.control.AppManager;
import com.example.storeform.control.PreferenceUtil;
import com.example.storeform.control.Repository;
import com.example.storeform.data.MyRoomDatabase;

class BaseViewModel extends ViewModel {


    protected Repository repository;
    protected AppManager appManager;
    protected Handler handler;
    protected PreferenceUtil preferenceUtil;
    protected MyRoomDatabase db;


    public BaseViewModel() {
        handler = new Handler();
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }


    public void setAppManage(AppManager appManager) {
        this.appManager = appManager;
    }


    public void setPreferenceUtil(PreferenceUtil preferenceUtil) {
        this.preferenceUtil = preferenceUtil;
    }


    public void setDb(MyRoomDatabase db) {
        this.db = db;
    }


}
