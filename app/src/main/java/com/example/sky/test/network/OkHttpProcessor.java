package com.example.sky.test.network;

import java.util.concurrent.TimeUnit;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */

public class OkHttpProcessor implements IHttpProcessor {
//
//    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//
//    private OkHttpClient mOkhttpClient;

    public OkHttpProcessor(){
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(10, TimeUnit.SECONDS);  //设置连接超时时间
//        builder.writeTimeout(10, TimeUnit.SECONDS);//设置写入超时时间
//        builder.readTimeout(30, TimeUnit.SECONDS);//设置读取数据超时时间
//        builder.retryOnConnectionFailure(false);//设置不进行连接失败重试
//        mOkhttpClient = builder.build();
    }

    private boolean checkNet() {
        return false;
    }

    @Override
    public void post(final HttpRequest.Builder builder, final ICallback callback) {
//        if (checkNet()) {
//            callback.onFail(-1, HttpError.getReqErrorMsg(HttpError.NETWORK_DISABLE_EXCEPTION));
//        } else {
//            //设置读取缓存，并且缓存不过期的情况下,读取缓存
//            if (builder.readCache && !CacheManager.getInstance().isCacheOutofDate(builder.url, builder.cacheTime)) {
//                String result = CacheManager.getInstance().loadCache(builder.url);
//                //读取不到继续请求
//                if (result != null) {
//                    callback.onHttpSuccess(0,result);
//                    return;
//                }
//            }
//            //设置过滤标记
//
//            try {
//                String params = HttpUtils.convertExtraJson(builder.params);
//                LogUtil.i("haover", "post params="+params+" builder.url="+builder.url);
//
//                Request request = new Request.Builder()
//                        .headers(HttpUtils.getOKhttpHeaders().build())
//                        .url(builder.url)
//                        .post(RequestBody.create(JSON, HttpUtils.convertExtraJson(builder.params)))
//                        .build();
//
//                if (builder.asy) {
//                    //异步
//                    mOkhttpClient.newCall(request).enqueue(new Callback() {
//                        @Override
//                        public void onFailure(Call call, final IOException e) {
//                            LogUtil.i("haover", "post onFailure e="+e.getMessage());
//                            App.postMainThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    callback.onFail(-1, e.getMessage());
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onResponse(Call call, final Response response) throws IOException {
//                            LogUtil.i("haover", "post onResponse 11111");
//                            if (response.isSuccessful()) {
//                                LogUtil.i("haover", "post onResponse 2222");
//                                final String content = response.body().string();
//                                LogUtil.i("haover", "post onResponse content="+content);
//                                App.postMainThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        writeCache(builder,response.body().toString());
//                                        if (!builder.parseResponse) {
//                                            try {
//                                                JSONObject object = new JSONObject(content);
//                                                object.remove("data");
//                                                callback.onHttpSuccess(response.code(), object.toString());
//                                            }catch (Exception e) {
//
//                                            }
//                                            return;
//                                        }
//                                        callback.onHttpSuccess(response.code(), content);
//                                    }
//                                });
//                            }else {
//                                App.postMainThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        LogUtil.i("haover", "post onResponse 3333");
//                                        callback.onFail(-1, response.message());
//                                    }
//                                });
//
//                            }
//                        }
//                    });
//                } else {
//                    //同步
//                    final Response response = mOkhttpClient.newCall(request).execute();
//                    if (response.isSuccessful()) {
//                        final String content = response.body().string();
//                        App.postMainThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (!builder.parseResponse) {
//                                    try {
//                                        JSONObject object = new JSONObject(content);
//                                        object.remove("data");
//                                        callback.onHttpSuccess(response.code(), object.toString());
//                                    }catch (Exception e) {
//
//                                    }
//                                    return;
//                                }
//                                callback.onHttpSuccess(response.code(), content);
//                            }
//                        });
//                    }else {
//                        App.postMainThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                callback.onFail(-1, response.message());
//                            }
//                        });
//                    }
//                }
//            } catch (Exception e) {
//                App.postMainThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onFail(-1,HttpError.getReqErrorMsg(HttpError.PARSE_EXCEPTION));
//                    }
//                });
//
//            }
//        }

    }

    @Override
    public void get(HttpRequest.Builder builder,ICallback callback) {

    }

    @Override
    public void delete(HttpRequest.Builder builder,ICallback callback) {

    }

    @Override
    public void put(HttpRequest.Builder builder,ICallback callback) {

    }


    private void writeCache(final HttpRequest.Builder builder, final String  result) {
//        if (!builder.cache || TextUtils.isEmpty(builder.url)) {
//            return;
//        }
//        final CacheManager instance = CacheManager.getInstance();
//        instance.getExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                if (instance.saveCache(result, builder.url)) {
//                    LogUtils.v(String.format("put cache alias:%s", builder.alias));
//                }
//            }
//        });
    }
}
