package com.example.sky.test;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.sky.test.activity.AnimationActivity;
import com.example.sky.test.activity.BookManagerActivity;
import com.example.sky.test.activity.CustomWeekActivity;
import com.example.sky.test.activity.DouyinLikeViewActivity;
import com.example.sky.test.activity.EditTextActivity;
import com.example.sky.test.activity.ImageScaleActivity;
import com.example.sky.test.activity.RefreshActivity;
import com.example.sky.test.activity.TouchActivity;
import com.example.sky.test.activity.TraceViewTestActivity;
import com.example.sky.test.activity.VerticalActivity;
import com.example.sky.test.activity.ViewActivity;
import com.example.sky.test.activity.ViewPagerMoreActivity;
import com.example.sky.test.model.JumpBeans;
import com.example.sky.test.sound.GameSoundPlayer;
import com.example.sky.test.sound.SoundPoolPlayer;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

    }

    public void onclick(View v){
        Intent intent = new Intent(this,DouyinLikeViewActivity.class);
//        JumpBeans beans = new JumpBeans();
//        beans.setmUri(Uri.parse("http://www.baidu.com"));
//        intent.putExtra("ceshi",beans);
        startActivity(intent);
////        GameSoundPlayer.play(GameSoundPlayer.game_sound_daojishi);
//        showShare();
//        Uri uri = Uri.parse("mktv://stream?stream_id=z1.appphp.59fc2fefd425e14fcf5aede1&anchor_id=10000074&type=1");
//        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
//        oks.disableSSOWhenAuthorize();

        oks.setPlatform(QQ.NAME);

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("新用户瓜分50亿大圣币");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://dasheng.test.appgame.com/activity/xryl?from=dashengLive&to=qq");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("大圣Live新用户福利来袭，50亿大圣币等你瓜分，手慢无哦~");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl("https://dn-fDD8GeyB.qbox.me/7ca1ff635f971bc5d73f.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用git
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("oks","onComplete");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("oks","onError");
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("oks","onCancel");
            }
        });

// 启动分享GUI
        oks.show(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG,"onNewIntent");
    }
}
