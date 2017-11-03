package com.example.sky.test.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * 功能：
 * Created by xuzhiyong on 17/10/20.
 */

public class RefreshFooterView extends LinearLayout implements RefreshFooter {


    private TextView mHeaderText;//标题文本

    public RefreshFooterView(Context context) {
        super(context);
        initView(context);
    }

    public RefreshFooterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RefreshFooterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setBackgroundColor(Color.parseColor("#ffffff"));
        mHeaderText = new TextView(context);
        mHeaderText.setTextColor(Color.parseColor("#ffffff"));
        addView(mHeaderText, FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        setMinimumHeight(180);
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.FixedBehind;
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case Loading:
                mHeaderText.setText("加载更多。。。");
                break;
            case LoadFinish:
                mHeaderText.setText("加载完成");
                break;
            case ReleaseToLoad:
                mHeaderText.setText("加载更多。。。");
                break;
        }
    }
}
