package com.example.storeform.base;


import android.util.Log;

import com.example.storeform.BuildConfig;

/**
 * Created by YurikoMatsuki on 11/26/2018.
 * Phone : 0439312984
 * Mail : yurikomatsuki2702@gmail.com
 * Skype : yuriko2702
 */
public class Logger {
    private static boolean isDebug = true;
    private static String TAG = BuildConfig.APPLICATION_ID;

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug) Log.v(tag, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug) Log.d(tag, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug) Log.i(tag, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug) Log.w(tag, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug) Log.e(tag, msg);
    }

    public static void longLog(String tag, String veryLongString) {
        int maxLogSize = 2000;
        for (int i = 0; i <= veryLongString.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > veryLongString.length() ? veryLongString.length() : end;
            d(tag, veryLongString.substring(start, end));
        }
    }

    public static void longLog(String veryLongString) {
        int maxLogSize = 4000;
        for (int i = 0; i <= veryLongString.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > veryLongString.length() ? veryLongString.length() : end;
            d(veryLongString.substring(start, end));
        }
    }
}
