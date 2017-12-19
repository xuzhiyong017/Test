package com.example.sky.test.network;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */

public class HttpRequest{

    private  IHttpProcessor mHttpProcessor = new OkHttpProcessor();
    private Builder mBuilder;

    public HttpRequest(Builder builder){
        this.mBuilder = builder;
    }


    public void get(ICallback callback) {
        mHttpProcessor.get(mBuilder,callback);
    }


    public void post(ICallback callback) {
        mHttpProcessor.post(mBuilder,callback);
    }


    public void delete(ICallback callback) {
        mHttpProcessor.delete(mBuilder,callback);
    }


    public void put(ICallback callback) {
        mHttpProcessor.put(mBuilder,callback);
    }


    public static class Builder {
        String url;
        Map<String, Object> params = new HashMap<>();
        boolean asy = true;//是否异步
        boolean readCache = false;//是否读取缓存
        boolean cache = false;//是否缓存
        boolean parseResponse = true;//是否将返回结果解析成对象，默认是解析
        long cacheTime;//缓存时间
        String alias;//过滤标记

        public HttpRequest.Builder parseResponse(boolean parseResponse) {
            this.parseResponse = parseResponse;
            return this;
        }

        public HttpRequest.Builder readCache(boolean readCache) {
            this.readCache = readCache;
            return this;
        }

        public HttpRequest.Builder cache(boolean cache) {
            this.cache = cache;
            return this;
        }

        public HttpRequest.Builder cacheTime(long cacheTime) {
            this.cacheTime = cacheTime;
            return this;
        }

        public HttpRequest.Builder url(String url) {
            this.url = url;
            return this;
        }

        public HttpRequest.Builder addParams(String key, Object values) {
            params.put(key, values);
            return this;
        }

        public HttpRequest.Builder asy(boolean asy) {
            this.asy = asy;
            return this;
        }

        public Builder() {
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

    }
}
