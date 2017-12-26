package com.example.sky.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sky.test.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
    }

    public void changeScaleType(View view){
        SimpleDraweeView image = (SimpleDraweeView) findViewById(R.id.image_simple);
        GenericDraweeHierarchy hierarchy = image.getHierarchy();
        if(image.getScaleType() == ImageView.ScaleType.CENTER_CROP){
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }else{
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}
