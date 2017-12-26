package com.example.sky.test.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.sky.test.R;
import com.example.sky.test.view.ViewItemInfo;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;


public class ViewPagerMoreActivity extends AppCompatActivity {

    private VerticalViewPager mViewpager;
    private ViewpagerAdapter mAdapter;
    private List<String> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_more);
        mViewpager = (VerticalViewPager) findViewById(R.id.flexViewpager);
        mAdapter = new ViewpagerAdapter();

        mViewpager.setAdapter(mAdapter);
        for(int i = 0 ; i < 10 ; i++){
            lists.add(""+i);
        }
        mAdapter.notifyDataSetChanged();
    }



    public class ViewpagerAdapter extends PagerAdapter {




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
