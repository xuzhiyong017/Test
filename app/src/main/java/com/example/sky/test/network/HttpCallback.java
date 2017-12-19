package com.example.sky.test.network;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */


public abstract class HttpCallback<T> implements ICallback {

    @Override
    public void onHttpSuccess(int code,String result) {
//        Gson gson = new Gson();
//        Type type = analysisClassInfo(this);
//        T t = gson.fromJson(result,type);
//        onSuccess(t);
    }

    public abstract void onSuccess(T t);

    public static Type analysisClassInfo(Object object){
        Type type = object.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType)type).getActualTypeArguments();
        return types[0];
    }
}


