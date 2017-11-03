package com.example.sky.test.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sky.test.Book;
import com.example.sky.test.IBookManager;
import com.example.sky.test.R;
import com.example.sky.test.server.BookManageService;

import java.util.List;

public class BookManagerActivity extends AppCompatActivity {

    public static final String TAG = "BookManagerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manager);
        Intent intent = new Intent(this, BookManageService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager = IBookManager.Stub.asInterface(service);

            try {
                List<Book> list = bookManager.getBookList();
                Log.i(TAG, "onServiceConnected: listType="+list.getClass().getCanonicalName());
                Log.i(TAG, "onServiceConnected: list="+list.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
