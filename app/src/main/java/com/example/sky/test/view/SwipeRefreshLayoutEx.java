package com.example.sky.test.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by 91299 on 2017/10/22   0022.
 */

public class SwipeRefreshLayoutEx extends SwipeRefreshLayout {

    private fr.castorflex.android.verticalviewpager.VerticalViewPager  mViewPager;

    public SwipeRefreshLayoutEx(Context context) {
        super(context);
    }

    public SwipeRefreshLayoutEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG","dispatchTouchEvent ="+ev.toString());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(mViewPager != null && mViewPager.getCurrentItem() != 0){
            return false;
        }



        boolean returnValue = super.onInterceptTouchEvent(ev);
        Log.e("TAG","returnValue="+returnValue+""+ev.toString());
        return returnValue;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("TAG","onTouchEvent ="+ev.toString());
        return super.onTouchEvent(ev);
    }

    public void setViewPager(fr.castorflex.android.verticalviewpager.VerticalViewPager mViewPager) {
        this.mViewPager = mViewPager;
    }
}
