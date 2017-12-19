package com.example.sky.test.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.example.sky.test.R;
import com.example.sky.test.view.SwipeRefreshLayoutEx;
import com.example.sky.test.view.ViewItemInfo;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class VerticalActivity extends AppCompatActivity {

    private SwipeRefreshLayoutEx mEx;
    private VerticalViewPager mViewPager;
    private ViewpagerAdapter mAdapter;
    private List<String> lists = new ArrayList<>();
    List<View> views = new ArrayList<>();
    private String[] color = {"#000000","#ffffff","#E5e5e5"};
    private int lastPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);


        TextView textview = new TextView(this);
        textview.setText("popwindow");
        PopupWindow window = new PopupWindow(this);
        window.setContentView(textview);
        window.showAtLocation(findViewById(R.id.swipe_refresh), Gravity.NO_GRAVITY,0,0);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        mViewPager = (VerticalViewPager) findViewById(R.id.viewpager);
//        mViewPager.setMinPageOffset(0.1f);
        mEx = (SwipeRefreshLayoutEx) findViewById(R.id.swipe_refresh);
        mEx.setViewPager(mViewPager);


//        View view0 = View.inflate(this,R.layout.item,null);
//        View view2 = View.inflate(this,R.layout.item,null);
//        View view3= View.inflate(this,R.layout.item,null);
//        views.add(view0);
//        views.add(view2);
//        views.add(view3);





        mAdapter = new ViewpagerAdapter();
        mViewPager.setAdapter(mAdapter);
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                lastPosition = position;
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                if(state == android.support.v4.view.ViewPager.SCROLL_STATE_IDLE){
////                    try {
////                        Thread.sleep(50l);
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
//                }
//            }
//        });

        for(int i = 0 ; i < 100 ; i++){
            lists.add(""+i);
        }
        mAdapter.notifyDataSetChanged();




        mEx.setProgressViewOffset(false,60,120);
        mEx.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                mEx.setRefreshing(true);
                mViewPager.postDelayed(mScrollable,2000L);
            }
        });

    }

    public void onclick(View v){
        mViewPager.setCurrentItem(2,false);
    }


    private Runnable mScrollable = new Runnable() {
        @Override
        public void run() {
//            if(lastPosition+1 < lists.size()){
//                mViewPager.setCurrentItem(lastPosition+1,true);
//                mViewPager.postDelayed(this,2000L);
//            }
            mEx.setRefreshing(false);
        }
    };

    public class ViewpagerAdapter extends PagerAdapter{




        public ViewpagerAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ViewItemInfo itemInfo = new ViewItemInfo(container.getContext());
            itemInfo.update(position);
            container.addView(itemInfo);
            return itemInfo;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
