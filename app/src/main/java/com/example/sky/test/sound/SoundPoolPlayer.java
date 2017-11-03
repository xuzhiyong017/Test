package com.example.sky.test.sound;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v4.util.ArrayMap;
import android.util.SparseIntArray;

import com.example.sky.test.ThreadBus;

/**
 * 功能：
 * Created by xuzhiyong on 17/5/17.
 */

public enum SoundPoolPlayer {
    sInstance;

    private static final int MAX_SOUND = 10;
    private static final int SOUND_QUALITY = 0;
    private static final int SoundPoolThreadId = Integer.MAX_VALUE - 10;

    private SoundPool mSoundPool;
    private ArrayMap<SoundPlayParams, Integer> mSoundMap;
    //为了stop用的
    private SparseIntArray mCanStoppedSounds;

    private SoundPool.OnLoadCompleteListener mOnLoadCompleteListener = new SoundPool.OnLoadCompleteListener() {

        @Override
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            doPlay(soundPool, sampleId, status);
        }
    };

    SoundPoolPlayer() {
        ThreadBus.bus().addThread(SoundPoolThreadId, "soundpool");
    }

    private void initSoundPool() {
        ThreadBus.bus().callThreadSafe(SoundPoolThreadId, new Runnable() {
            @Override
            public void run() {
                mSoundPool = new SoundPool(MAX_SOUND, AudioManager.STREAM_MUSIC, SOUND_QUALITY);

                mSoundMap = new ArrayMap<>();
                mCanStoppedSounds = new SparseIntArray();

                mSoundPool.setOnLoadCompleteListener(mOnLoadCompleteListener);
            }
        });
    }

    private void play(final SoundPlayParams params) {
        ThreadBus.bus().callThreadSafe(SoundPoolThreadId, new Runnable() {
            @Override
            public void run() {
                if (mSoundMap != null && mSoundMap.size() > 100) {
                    release();
                }

                if (mSoundPool == null || mSoundMap == null) {
                    initSoundPool();
                }

                Integer soundId = mSoundMap.get(params);

                if (soundId == null) {
                    //load完一个音效，unload它，再load后，soundID会增加，待增到300左右时音效放不出，
                    //play返回的streamid为0.只能release掉后再new一个soundpool
                    //暂无处理，因为总的音效数量不多
                    soundId = params.load(mSoundPool);

                    if (soundId != 0) {
                        mSoundMap.put(params, soundId);
                    }
                } else {
                    float volume = getCurrentVolume();

                    int streamId = mSoundPool.play(soundId, volume, volume, 1, 0, 1.0f);

                    if (streamId == 0) {
//                        JLog.error(SoundPoolPlayer.this, "play sound failed params : "
//                                + params.toString());
                    } else {
                        mSoundPool.setVolume(streamId, volume, volume);

                        mCanStoppedSounds.put(soundId, streamId);
                    }
                }
            }
        });
    }

    private void doPlay(final SoundPool soundPool, final int sampleId, final int status) {
        ThreadBus.bus().callThreadSafe(SoundPoolThreadId, new Runnable() {
            @Override
            public void run() {
                if (status == 0) {
                    float volume = getCurrentVolume();

                    int streamId = soundPool.play(sampleId, volume, volume, 1, 0, 1.0f);

                    if (streamId == 0) {
//                        JLog.error(SoundPoolPlayer.this, "play sound failed sample id : " + sampleId);
                    } else {
                        soundPool.setVolume(streamId, volume, volume);

                        mCanStoppedSounds.put(sampleId, streamId);
                    }
                } else {
//                    JLog.error(SoundPoolPlayer.this, "load sound failed status :" + status);
                }
            }
        });
    }

    private void stop(final SoundPlayParams params) {
        ThreadBus.bus().callThreadSafe(SoundPoolThreadId, new Runnable() {
            @Override
            public void run() {
                if(mSoundMap != null) {
                    Integer soundId = mSoundMap.get(params);

                    if (soundId != null) {
                        Integer streamId = mCanStoppedSounds.get(soundId);

                        if(streamId != null) {
                            mSoundPool.stop(streamId);

                            mCanStoppedSounds.delete(soundId);
                        }
                    }
                }
            }
        });
    }

    private float getCurrentVolume() {
        return  1f;
    }

    private void release() {
        ThreadBus.bus().callThreadSafe(SoundPoolThreadId, new Runnable() {
            @Override
            public void run() {
                if (mSoundPool != null) {
                    mSoundPool.setOnLoadCompleteListener(null);
                    mSoundPool.release();
                    mSoundPool = null;
                }

                if (mSoundMap != null) {
                    mSoundMap.clear();
                    mSoundMap = null;
                }

                if(mCanStoppedSounds != null) {
                    mCanStoppedSounds.clear();
                    mCanStoppedSounds = null;
                }
            }
        });
    }

    public static void playAssets(String assetsFilePath) {
        sInstance.play(new AssetsSoundPlayParams(assetsFilePath));
    }

    public static void stopAssets(String assetsFilePath) {
        sInstance.stop(new AssetsSoundPlayParams(assetsFilePath));
    }
}
