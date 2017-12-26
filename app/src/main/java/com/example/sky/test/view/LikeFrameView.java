package com.example.sky.test.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sky.test.R;

import java.util.Random;

/**
 * 功能：
 * Created by xuzhiyong on 17/12/26.
 */

public class LikeFrameView extends FrameLayout {

    private Drawable icon = getResources().getDrawable(R.drawable.ic_heart);
    private GestureDetector mDetectorGesture;
    boolean isTouchDouble = false;


    public LikeFrameView(@NonNull Context context) {
        super(context);
        init();
    }

    public LikeFrameView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LikeFrameView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setClipChildren(false);
        setClickable(true);
        mDetectorGesture = new GestureDetector(getContext(), mGestureListenr);
    }


    GestureDetector.SimpleOnGestureListener mGestureListenr = new GestureDetector.SimpleOnGestureListener(){

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            addHeartView(x,y);
            isTouchDouble = true;
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if(isTouchDouble){
                isTouchDouble = false;
                onDoubleTap(e);
                return false;
            }
            Toast.makeText(getContext(),"单击",Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean touch = mDetectorGesture.onTouchEvent(event);
        Log.d("likeview", "onTouchEvent: "+touch);
        return true;
    }

    private void addHeartView(float x, float y) {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
        lp.leftMargin = (int)(x - icon.getIntrinsicWidth()/2);
        lp.topMargin = (int)(y - icon.getIntrinsicHeight());
        final ImageView img = new ImageView(getContext());
        img.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postRotate(getRandomRotate());
        img.setImageMatrix(matrix);
        img.setImageDrawable(icon);
        img.setLayoutParams(lp);
        addView(img);
        AnimatorSet animSetShow = getShowAnimSet(img);
        final AnimatorSet animSethide = getHideAnimSet(img);
        animSetShow.start();
        animSetShow.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animSethide.start();
            }
        });
        animSethide.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                removeView(img);
            }
        });
    }


    /**
     * 刚点击的时候的一个缩放效果
     */
    private AnimatorSet getShowAnimSet(ImageView view) {
        // 缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.2f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.2f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(scaleX, scaleY);
        animSet.setDuration(100);
        return animSet;
    }

    /**
     * 缩放结束后到红心消失的效果
     */
    private AnimatorSet getHideAnimSet(ImageView view){
        // 1.alpha动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f);
        // 2.缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 2f);
        // 3.translation动画
        ObjectAnimator translation = ObjectAnimator.ofFloat(view, "translationY", 0f, -150f);
        AnimatorSet animSet =new  AnimatorSet();
        animSet.playTogether(alpha, scaleX, scaleY, translation);
        animSet.setDuration(500);
        return animSet;
    }


    private float getRandomRotate() {
        Random random = new Random();
        Float rotate = random.nextInt(20) - 10.0f;
        return rotate;
    }
}
