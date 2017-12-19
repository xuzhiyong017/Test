package com.example.sky.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sky.test.R;

/**
 * 功能：
 * Created by xuzhiyong on 17/11/10.
 */

public class ViewItemInfo extends RelativeLayout {

    private TextView textView;
    private int mCount = 0;
    private int mPosition;

    private GestureDetector mDetectorGesture;
    private View mTouchView;

    public ViewItemInfo(Context context) {
        super(context);
        init();
    }


    public ViewItemInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewItemInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        View.inflate(getContext(), R.layout.item,this);
        textView = (TextView) findViewById(R.id.text_num);
        mTouchView =  findViewById(R.id.touch_view);
        mDetectorGesture = new GestureDetector(getContext(), mGestureListenr);
        mTouchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetectorGesture.onTouchEvent(event);
                return false;
            }
        });
    }

    public void update(int position){
        mPosition = position;
        textView.setText(""+position);
//        textView.post(mRunnable);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        boolean dispatch = super.dispatchTouchEvent(ev);
        return dispatch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        mDetectorGesture.onTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

    public Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            textView.setText("当="+mPosition+" count="+mCount++);
            textView.postDelayed(this,1000);
        }
    };

    private GestureDetector.SimpleOnGestureListener mGestureListenr = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("TouchActivity","onSingleTapConfirmed");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {

            Log.d("TouchActivity","onDoubleTap");

            return false;
        }
    };

}
