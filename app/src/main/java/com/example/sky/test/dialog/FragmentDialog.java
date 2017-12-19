package com.example.sky.test.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sky.test.R;
import com.example.sky.test.activity.TouchActivity;
import com.example.sky.test.activity.VerticalActivity;

/**
 * 功能：
 * Created by xuzhiyong on 17/11/29.
 */

public class FragmentDialog extends BottomSheetDialogFragment {

    private TextView mTextView;
    private View mContentView;

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mContentView = inflater.inflate(R.layout.fragment_dialog,container,false);
        initView();
        return mContentView;
    }

    private void initView() {
        mTextView = (TextView) mContentView.findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContentView.getContext(), VerticalActivity.class));
            }
        });
    }
}
