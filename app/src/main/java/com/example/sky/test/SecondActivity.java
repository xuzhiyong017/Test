package com.example.sky.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        Log.d(TAG,"onCreate");
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        for (int i = 0; i < 30; i++) {
            list.add(""+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TestAdapter());

    }


    public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewItem(new TextView(parent.getContext()));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((TextView)holder.itemView).setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            Log.d("testAdapter","count="+list.size());
            return list.size();
        }

        @Override
        public int getItemViewType(int position) {
            Log.d("testAdapter","getItemViewType="+super.getItemViewType(position));
            return super.getItemViewType(position);
        }
    }

    public class ViewItem extends RecyclerView.ViewHolder{

        private TextView mTextView;

        public ViewItem(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
                }
            });
        }
    }
}
