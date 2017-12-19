package com.example.sky.test.network;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */

public interface ICallback {
    public void onHttpSuccess(int code,String result);
    public void onFail(int code,String message);
}
