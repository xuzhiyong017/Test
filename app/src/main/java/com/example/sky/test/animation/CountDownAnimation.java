package com.example.sky.test.animation;

import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * 功能：
 * Created by xuzhiyong on 17/9/17.
 */

public class CountDownAnimation {

    private TextView mTextView;
    private Animation mAnimation;
    private int mStartCount;
    private int mCurrentCount;
    private CountDownListener mListener;
    private long mDuration = TimeUnit.SECONDS.toMillis(1);
    private Handler mHandler = new Handler();

    private final Runnable mCountDown = new Runnable() {
        public void run() {
            if (mCurrentCount > 0) {
                mTextView.setText(mCurrentCount + "");
                mTextView.startAnimation(mAnimation);
                mCurrentCount--;
            } else {
                mTextView.setVisibility(View.GONE);
                if (mListener != null)
                    mListener.onCountDownEnd(CountDownAnimation.this);
            }
        }
    };

    /**
     * @param textView 倒计时TextView
     * @param startCount 倒计时开始的数字
     */
    public CountDownAnimation(TextView textView, int startCount) {
        this.mTextView = textView;
        this.mStartCount = startCount;
        initAnimation();
    }

    private void initAnimation() {
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        mAnimation = animationSet;
        mAnimation.setDuration(mDuration);
    }

    /**
     * Starts the count down animation.
     */
    public void start() {
        mHandler.removeCallbacks(mCountDown);
        mTextView.setText(mStartCount + "");
        mTextView.setVisibility(View.VISIBLE);
        mCurrentCount = mStartCount;
        mHandler.post(mCountDown);
        for (int i = 1; i <= mStartCount; i++) {
            mHandler.postDelayed(mCountDown, i * mDuration);
        }
    }

    public void cancel() {
        mHandler.removeCallbacks(mCountDown);
        mTextView.setText("");
        mTextView.setVisibility(View.GONE);
    }


    public void setAnimation(Animation animation) {
        this.mAnimation = animation;
        long duration = mAnimation.getDuration();
        if (duration == 0) {
            mAnimation.setDuration(mDuration);
        }else{
            mDuration = duration;
        }
    }

    /**
     * @param startCount 倒计时开始的数字
     */
    public void setStartCount(int startCount) {
        this.mStartCount = startCount;
    }

    public void setCountDownListener(CountDownListener listener) {
        mListener = listener;
    }

    public interface CountDownListener {
        void onCountDownEnd(CountDownAnimation animation);
    }
}
