package com.example.sky.test.sound;

import android.media.SoundPool;

/**
 * Created by Administrator on 2016/5/6.
 *
 */
public abstract class SoundPlayParams {

	@Override
	public int hashCode() {
		return soundPlayParamsHashCode();
	}

	@Override
	public boolean equals(Object o) {
		return isSoundPlayParamsEquals(o);
	}

	public abstract int soundPlayParamsHashCode();

	public abstract boolean isSoundPlayParamsEquals(Object o);

	public abstract int load(SoundPool soundPool);
}
