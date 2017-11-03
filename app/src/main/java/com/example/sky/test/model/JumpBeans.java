package com.example.sky.test.model;

import android.net.Uri;

import java.io.Serializable;

/**
 * 功能：
 * Created by xuzhiyong on 17/9/18.
 */

public class JumpBeans implements Serializable {


    public Uri getmUri() {
        return mUri;
    }

    public void setmUri(Uri mUri) {
        this.mUri = mUri;
    }

    private Uri mUri;

    public JumpBeans(){

    }


}
