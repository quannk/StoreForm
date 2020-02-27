package com.example.storeform.mvc;


public interface IModel {

    <T> T put(Object key, Object value);

    <T> T get(Object key);

    <T> T remove(Object key);

    IModel newChild(Object key);

    IModel getChild(Object key);
}
