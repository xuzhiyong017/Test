package com.example.sky.test.network;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */


public interface IHttpProcessor {

    public void get(HttpRequest.Builder builder,ICallback callback);
    public void post(HttpRequest.Builder builder,ICallback callback);
    public void delete(HttpRequest.Builder builder,ICallback callback);
    public void put(HttpRequest.Builder builder,ICallback callback);
}

