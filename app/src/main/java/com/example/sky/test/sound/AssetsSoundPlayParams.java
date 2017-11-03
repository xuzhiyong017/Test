package com.example.sky.test.sound;

import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.support.annotation.NonNull;


import com.example.sky.test.App;
import com.example.sky.test.JStringUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/6.
 *
 */
public class AssetsSoundPlayParams extends SoundPlayParams {

	public String assetsFilePath;

	public AssetsSoundPlayParams(@NonNull String assetsFilePath) {
		this.assetsFilePath = assetsFilePath;
	}

	@Override
	public int soundPlayParamsHashCode() {
		return JStringUtils.combineStr("assets://", assetsFilePath).hashCode();
	}

	@Override
	public boolean isSoundPlayParamsEquals(Object o) {
		if (o == null || !(o instanceof AssetsSoundPlayParams)) {
			return false;
		}

		return assetsFilePath.equals(((AssetsSoundPlayParams) o).assetsFilePath);
	}

	@Override
	public int load(SoundPool soundPool) {
		int soundId = 0;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = App.mContext.getAssets().openFd(assetsFilePath);
			soundId = soundPool.load(assetFileDescriptor, 1);
		} catch (IOException e) {
//			JLog.error(this, "load sound assets failed : " + e);
		} finally {
            if (null != assetFileDescriptor) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e) {
//                    JLog.error(this, "close sound assets failed : " + e.getMessage());
                }
            }
        }

		return soundId;
	}

	@Override
	public String toString() {
		return JStringUtils.combineStr("assets://", assetsFilePath);
	}
}
