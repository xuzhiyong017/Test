package com.example.sky.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * 功能：
 * Created by xuzhiyong on 17/9/12.
 */

public class ViewTouch extends RelativeLayout {

    private final static String TAG = "ViewTouch";
    private float lastXIntercept;
    private float lastYIntercept;

    public ViewTouch(Context context) {
        super(context);
    }

    public ViewTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewTouch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean intercepted = false;
//        float x =  ev.getX();
//        float y =  ev.getY();
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.d(TAG, "onInterceptTouchEvent: ACTION_DOWN");
//
//                lastXIntercept = x;
//                lastYIntercept = y;
//                intercepted = false;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.d(TAG, "onInterceptTouchEvent: ACTION_MOVE");
//
//                final float deltaX = x - lastXIntercept;
//                final float deltaY = y - lastYIntercept;
//                /*根据条件判断是否拦截该事件*/
//                if (Math.abs(deltaY) > Math.abs(deltaX)) {
//                     intercepted = true;
//                 } else {
//                     intercepted = false;
//                }
//
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.d(TAG, "onInterceptTouchEvent: ACTION_UP");
//                intercepted = false;
//                break;
//        }
//
//        lastXIntercept = x;
//        lastYIntercept = y;
//
//        return intercepted;

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onInterceptTouchEvent: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onInterceptTouchEvent: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onInterceptTouchEvent: ACTION_UP");
                break;
        }
//
//
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent: ACTION_UP");
                break;
        }

        return super.onTouchEvent(event);
    }
}
