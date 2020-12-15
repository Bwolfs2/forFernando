package com.example.myapplication;


/**
 * Created by cesarferreira on 30/05/14.
 * https://gist.github.com/cesarferreira/ef70baa8d64f9753b4da
 */
public interface OnEventListener<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}