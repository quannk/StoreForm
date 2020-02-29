package com.example.storeform.control;

import android.content.Context;

public class PreferenceUtil {
    private static String userId;
    private static String sessionId;
    private boolean isLoginSuccess;

    public PreferenceUtil(Context context) {
    }

    public static String getSessionId() {
        return sessionId;
    }

    public boolean getLoginSuccess() {
        return isLoginSuccess;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        PreferenceUtil.userId = userId;
    }

    public static void setSessionId(String sessionId) {
        PreferenceUtil.sessionId = sessionId;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        isLoginSuccess = loginSuccess;
    }

    public String getDomainThumb() {
        return "";
    }
}
