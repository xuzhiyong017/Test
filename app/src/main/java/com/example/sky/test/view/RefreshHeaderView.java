package com.example.sky.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * 功能：
 * Created by xuzhiyong on 17/10/20.
 */

public class RefreshHeaderView extends FrameLayout implements RefreshHeader {


    private TextView mHeaderText;//标题文本

    public RefreshHeaderView(Context context) {
        super(context);
        initView(context);
    }



    public RefreshHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mHeaderText = new TextView(context);
        addView(mHeaderText, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        setMinimumHeight(180);
    }

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.FixedFront;
    }

    @Override
    public void setPrimaryColors(int... colors) {

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
        if(success){
            mHeaderText.setText("刷新完成");
        }else{
            mHeaderText.setText("刷新失败");
        }
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
            case PullDownToRefresh:
                mHeaderText.setText("松开刷新内容");
                break;
            case Refreshing:
                mHeaderText.setText("正在刷新");
                break;
            case ReleaseToRefresh:
                mHeaderText.setText("松开刷新内容");
                break;
        }
    }
}
