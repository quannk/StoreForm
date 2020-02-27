package com.example.storeform;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storeform.control.AppManager;
import com.example.storeform.control.PreferenceUtil;
import com.example.storeform.control.Repository;

public class BaseActivity extends AppCompatActivity {
    protected Repository repository;
    protected PreferenceUtil preferenceUtil;
    protected AppManager appManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        init();
    }

    private void init() {
        repository = Repository.getInstance(this);
        appManager = AppManager.getInstance(this);
        preferenceUtil = new PreferenceUtil(this);
        repository.setDataType(appManager.apiType);
//        poolModule.isLoggerDebug(false);  bỏ comment nếu đang build release...
    }


}
