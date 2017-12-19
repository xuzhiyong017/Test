package com.example.sky.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sky.test.R;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        findViewById(R.id.text).setSelected(true);
        findViewById(R.id.tv_topic_content).setSelected(true);
        findViewById(R.id.tv_topic_content_top).setSelected(true);
        findViewById(R.id.view_touch).postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.view_touch).requestLayout();
                findViewById(R.id.view_touch).postDelayed(this,200L);
            }
        },200);
    }
}
