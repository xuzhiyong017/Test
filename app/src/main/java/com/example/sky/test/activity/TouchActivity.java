package com.example.sky.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sky.test.R;

public class TouchActivity extends AppCompatActivity {


    View mTextView;
    private GestureDetector mDetectorGesture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        mTextView = findViewById(R.id.text);
        mDetectorGesture = new GestureDetector(this, mGestureListenr);
        mTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetectorGesture.onTouchEvent(event);
                return false;
            }
        });
    }


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
