package com.example.sky.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 功能：
 * Created by xuzhiyong on 17/10/23.
 */

public class VerticalViewPager extends ViewPager {

    private int count = 0;

    public VerticalViewPager(Context context) {
        this(context, null);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        //设置viewpage的切换动画,这里设置才能真正实现垂直滑动的viewpager
        setPageTransformer(true, new DefaultTransformer());
    }

    /**
     * 拦截touch事件
     *
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(swapEvent(ev));
        Log.d("VerticalViewPager", "onInterceptTouchEvent: intercepted="+intercepted+"\n"+ev.toString());
        swapEvent(ev); // return touch coordinates to original reference frame for any child views
        return intercepted;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("VerticalViewPager", "onTouchEvent: "+ev.toString());
        return super.onTouchEvent(swapEvent(ev));
    }

    private MotionEvent swapEvent(MotionEvent event) {
        //获取宽高
        float width = getWidth();
        float height = getHeight();
        //将Y轴的移动距离转变成X轴的移动距离
        float swappedX = (event.getY() / height) * width;
        //将X轴的移动距离转变成Y轴的移动距离
        float swappedY = (event.getX() / width) * height;
        //重设event的位置
        event.setLocation(swappedX, swappedY);
        return event;
    }

    public class DefaultTransformer implements ViewPager.PageTransformer {

        public static final String TAG = "simple";

        @Override
        public void transformPage(View view, float position) {

            float alpha = 0;
            if (0 <= position && position <= 1) {
                alpha = 1 ;
            } else if (-1 < position && position < 0) {
                alpha = 1;
            }
            view.setAlpha(alpha);
            float transX = view.getWidth() * -position;
            view.setTranslationX(transX);
            float transY = position * view.getHeight();
            view.setTranslationY(transY);
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("VerticalViewPager", "onMeasure: "+count++);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("VerticalViewPager", "onLayout: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
