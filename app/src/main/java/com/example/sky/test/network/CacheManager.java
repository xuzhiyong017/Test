package com.example.sky.test.network;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/5.
 */

import android.os.Environment;

import java.io.File;
import java.lang.reflect.Type;

/**
 * Created with Android Studio
 * </p>
 * Authour:xiaxf
 * </p>
 * Date:16/3/4.
 */
@Deprecated
public class CacheManager {

    private boolean needEencypt = false;//后期处理加密
    private SmartExecutor mExecutor = new SmartExecutor();
    private static final String CACHE_PATH = Environment.getExternalStorageDirectory() + "/dasheng.tv";//以后会迁移到 DirManager中。

    public static CacheManager getInstance() {
        return SingletonHolder.instance;
    }

    private CacheManager() {
        createCachePath();
    }

    private void createCachePath() {
        File file = new File(CACHE_PATH);
        if (!file.exists())
            file.mkdirs();
    }

    public <T> T loadCache(String url, Type type) {
//        String cache = FileUtil.readTxtFile(getCacheFile(url));
        //后期加密处理
//        if (needEencypt && TextUtils.isEmpty(cache)) {
//            cache = HttpUtils.decodeResponse(cache);
//        }
//        try {
//            return new Gson().fromJson(cache, type);
//        } catch (Exception e) {
//        }
        return null;
    }

    public String loadCache(String url){
//        String cache = FileUtil.readTxtFile(getCacheFile(url));
//        return cache;
        return "";
    }

    /**
     * 判断缓存是否过期
     *
     * @return
     */
    public boolean isCacheOutofDate(String url, long cacheTime) {
        return System.currentTimeMillis() - getCacheTime(url) > cacheTime;
    }

    private File getCacheFile(String url) {
        //后期做加密处理
//        String cachePath = DirManager.getInstance().getPath(Dir.CACHE_DATA) + "/" + SecurityUtils.getMd5(url, "UTF-8");
        String cachePath = CACHE_PATH + "/" + url;
        return new File(cachePath);
    }

    public boolean hasCache(String url) {
        return false;
//        return FileUtil.checkFileExists(getCacheFile(url).getAbsolutePath());
    }

    public boolean saveCache(String response, String url) {
        String result = response;
        //后期加密处理
//        if (needEencypt) {
//            reuslt = SecurityUtils.getMd5(response, "UTF-8");
//        }

        return false;
//        return FileUtil.writeTxtFile(result, getCacheFile(url));
    }

    private long getCacheTime(String url) {
        //返回文件最后创建的日期
        return getCacheFile(url).lastModified();
    }

    public SmartExecutor getExecutor() {
        return mExecutor;
    }

    private static class SingletonHolder {
        static final CacheManager instance = new CacheManager();
    }
}
