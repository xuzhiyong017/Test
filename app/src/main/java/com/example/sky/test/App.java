package com.example.sky.test;

import android.app.Application;
import android.content.Context;

import com.mob.commons.SHARESDK;

import cn.sharesdk.framework.ShareSDK;

/**
 * 功能：
 * Created by xuzhiyong on 17/5/17.
 */

public class App extends Application {

    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        ShareSDK.initSDK(this);
        R.drawabl
    }
}
