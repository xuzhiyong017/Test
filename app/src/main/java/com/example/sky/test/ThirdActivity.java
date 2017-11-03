package com.example.sky.test;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ThirdActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private TextView mTextView;
    private SurfaceView mSurfaceView;
    Camera camera;
    private SurfaceHolder surfaceholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mTextView = (TextView) findViewById(R.id.text_view);
        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);

        SpannableString ss;

        ss = new SpannableString(Html.fromHtml("发生的发<img src=\"http://ssfdfs\"",new NetImageGetter(),null));

        mTextView.setText(ss);


        surfaceholder = mSurfaceView.getHolder();
        surfaceholder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceholder.addCallback(this);


        mTextView.postDelayed(new Runnable() {
            @Override
            public void run() {
                MediaRecorder recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                recorder.setOutputFile(Environment.getExternalStorageDirectory()+"/record");
                try {
                    recorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recorder.start();
            }
        },10000);


    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("surfacecreated");
        Toast.makeText(this, "启动摄像头失败,请开启摄像头权限", Toast.LENGTH_SHORT).show();
        //获取camera对象
        camera = Camera.open();
        try {
            //设置预览监听
            camera.setPreviewDisplay(holder);
            Camera.Parameters parameters = camera.getParameters();

            if (this.getResources().getConfiguration().orientation
                    != Configuration.ORIENTATION_LANDSCAPE) {
                parameters.set("orientation", "portrait");
                camera.setDisplayOrientation(90);
                parameters.setRotation(90);
            } else {
                parameters.set("orientation", "landscape");
                camera.setDisplayOrientation(0);
                parameters.setRotation(0);
            }
            camera.setParameters(parameters);
            //启动摄像头预览
            camera.startPreview();
            System.out.println("camera.startpreview");

        } catch (Exception e) {
            e.printStackTrace();
            camera.release();
            System.out.println("camera.release");
        }


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        System.out.println("surfaceDestroyed");
        if (camera != null) {
            camera.stopPreview();
            camera.release();
        }
    }

    public class NetImageGetter implements Html.ImageGetter{

        @Override
        public Drawable getDrawable(final String source) {
            if(TextUtils.isEmpty(source) || "null".equals(source)) return null;
            Drawable drawable = null;
//            File file = ImageFileUtil.findByName(source.substring(source.lastIndexOf("/")+1));
//            if (file != null && file.exists()) {
//                drawable = Drawable.createFromPath(file.getAbsolutePath());
//                if(null != drawable){
//                    drawable.setBounds(0, -ApplicationUtils.dp2px(getContext(),14),ApplicationUtils.dp2px(getContext(),22),
//                            ApplicationUtils.dp2px(getContext(),6));
//                }
//            }
            return drawable;
        }
    }
}
