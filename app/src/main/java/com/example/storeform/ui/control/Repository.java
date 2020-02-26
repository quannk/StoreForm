package com.example.storeform.ui.control;

import android.content.Context;
import android.util.Log;

import com.example.storeform.socket.SocketManager;

import java.util.logging.Logger;

public class Repository {
    private static Repository instance;
    private SocketManager socketManager;

    public Repository(Context context) {
    }

    //Singleton

    public static Repository getInstance(Context context){
        if (instance != null){
            instance =  new Repository(context);
        }
        return instance;
    }

    public void setSocketData(String address, String port , String sessionId) {
        Log.d("TAG", "setSocketData");

        socketManager.initSocket(address, port,sessionId);
    }
}
