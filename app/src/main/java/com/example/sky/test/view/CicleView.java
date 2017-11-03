package com.example.sky.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能：
 * Created by xuzhiyong on 17/8/29.
 */

public class CicleView extends View {

    int len;
    private Paint mPaint;
    private RectF mRect;

    public CicleView(Context context) {
        super(context);
        init();
    }


    public CicleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CicleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        len = Math.min(width,height);
        setMeasuredDimension(len,len);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);

        float padding = 200/2;
        mRect = new RectF(padding, padding, len-padding, len-padding);


        mPaint.setStrokeWidth(100);
        for(int i = 0 ; i < 60 ; i ++ ){
            canvas.drawArc(mRect, i*10, 3, false, mPaint);
        }




    }
}
