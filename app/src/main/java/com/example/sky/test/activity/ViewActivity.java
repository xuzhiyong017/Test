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
    }
}
