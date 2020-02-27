package com.example.storeform.mvc;

import java.util.HashMap;
import java.util.Map;

class Controller implements IController{
    protected final Map<String, IView> views;

    public Controller() {
        this.views = new HashMap<>();
    }

    @Override
    public void addView(String action, IView view) {
        views.put(action, view);
    }

    @Override
    public void removeView(String action) {
        views.remove(action);
    }

    @Override
    public void updateView(String action) {
        updateView(action, null);
    }

    @Override
    public void updateView(String action, Object data) {
        IView view = views.get(action);
        if(view != null)
            view.update(data);
    }
}
