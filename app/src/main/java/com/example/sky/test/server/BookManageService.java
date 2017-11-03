package com.example.sky.test.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.sky.test.Book;
import com.example.sky.test.IBookManager;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 功能：
 * Created by xuzhiyong on 17/8/11.
 */

public class BookManageService extends Service {

    private static final String TAG = "BMS";

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();


    private Binder mBinder = new IBookManager.Stub(){

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1,"android"));
        mBookList.add(new Book(2,"Ios"));
    }
}
