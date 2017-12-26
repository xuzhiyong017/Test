package com.example.sky.test.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;


/**
 * 功能：
 * Created by xuzhiyong on 17/12/20.
 */

public class FlexibleViewPager extends fr.castorflex.android.verticalviewpager.VerticalViewPager {

    private float y;
    private int xMove;
    private boolean isMoveLeft = true;//左边是否能移动
    private boolean isMoveRight;
    private Rect normal = new Rect();//记录原来的位置
    private OnRefreshListener listener;

    public FlexibleViewPager(Context context) {
        super(context);
    }

    public FlexibleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                if(y == 0){
                    y = ev.getY();
                }
                xMove = (int)(y - ev.getY()) / 2;
                Log.e("FlexibleViewPager","xMove:" + xMove + "isMoveLeft:" + isMoveLeft + "isMoveRight:" + isMoveRight);
                if(isMoveLeft && xMove < 0 || isMoveRight && xMove >= 0){
                    this.layout(normal.left,-xMove,normal.right,normal.bottom - xMove);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if(isMoveRight || isMoveLeft){
                    animation(xMove);
                }
                break;

        }
        return super.onTouchEvent(ev);
    }


    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {//监听viewpager是否是第一页或最后一页
        if (getAdapter() == null && getAdapter().getCount() == 0) {
            isMoveLeft = false;
            isMoveRight = false;
        } else if (position == 0 && offset == 0 && offsetPixels == 0) {
            isMoveLeft = true;
        } else if (position == getAdapter().getCount() - 1 && offset == 0 && offsetPixels == 0) {
            isMoveRight = true;
        } else {
            isMoveLeft = false;
            isMoveRight = false;
        }
        if (normal.isEmpty() || normal.top - normal.bottom == 0) {
            normal.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());//viewpager记录原来位置
        }
        super.onPageScrolled(position, offset, offsetPixels);
    }

    private void animation(int moveX) {
        if (listener != null) {
            if (moveX > getHeight() / 6) {//滑动的距离超过屏幕的1/6才回调
                listener.onLoadMore();
            } else if (moveX < -getHeight() / 6) {
                listener.onRefresh();
            }
        }
        y = 0;
        TranslateAnimation ta = new TranslateAnimation(0, 0, this.getY(), normal.top);
        ta.setDuration(200);
        this.startAnimation(ta);
        this.layout(normal.left, normal.top, normal.right, normal.bottom);
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.listener = listener;
    }

    public interface OnRefreshListener {
        void onRefresh();

        void onLoadMore();
    }
}
