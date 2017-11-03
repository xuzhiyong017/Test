package com.example.sky.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sky.test.R;
import com.example.sky.test.animation.CountDownAnimation;

public class AnimationActivity extends AppCompatActivity {


    TextView mTextView;
    CountDownAnimation mAnimationCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mTextView = (TextView) findViewById(R.id.count_time);
        mAnimationCountDown = new CountDownAnimation(mTextView,1000);
        mAnimationCountDown.start();

    }
}
