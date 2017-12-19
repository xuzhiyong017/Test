package com.example.sky.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/12.
 */

public class WaveView extends View {

    private Paint mPaint = new Paint();
    private float[] mSampLingX;
    private static final int SAMPLINT_SIZE  = 128;

    public WaveView(Context context) {
        super(context);
        init();
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mSampLingX == null){
            mSampLingX = new float[SAMPLINT_SIZE +1];
        }
    }
}
