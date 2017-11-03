package com.example.sky.test.sound;



import java.util.WeakHashMap;

/**
 * Created by Administrator on 2016/5/19.
 *
 */
public class GameSoundPlayer {

	public static final String game_sound_allin_1 = "sound/allin_1.mp3";
	public static final String game_sound_allin_2 = "sound/allin_2.mp3";
	public static final String game_sound_allin_3 = "sound/allin_3.mp3";
	public static final String game_sound_allin_4 = "sound/allin_4.mp3";

	public static final String game_sound_daojishi = "sound/daojishi.mp3";

	public static final String game_sound_fapai1 = "sound/fapai1.mp3";
	public static final String game_sound_fapai2 = "sound/fapai2.mp3";
	public static final String game_sound_fapai3 = "sound/fapai3.mp3";

	public static final String game_sound_genzhu_1 = "sound/genzhu_1.mp3";
	public static final String game_sound_genzhu_2 = "sound/genzhu_2.mp3";
	public static final String game_sound_genzhu_3 = "sound/genzhu_3.mp3";
	public static final String game_sound_genzhu_4 = "sound/genzhu_4.mp3";

	public static final String game_sound_guopai = "sound/guopai.mp3";

	public static final String game_sound_jiazhu_1 = "sound/jiazhu_1.mp3";
	public static final String game_sound_jiazhu_2 = "sound/jiazhu_2.mp3";
	public static final String game_sound_jiazhu_3 = "sound/jiazhu_3.mp3";
	public static final String game_sound_jiazhu_4 = "sound/jiazhu_4.mp3";

	public static final String game_sound_qipai_1 = "sound/qipai_1.mp3";
	public static final String game_sound_qipai_2 = "sound/qipai_2.mp3";
	public static final String game_sound_qipai_3 = "sound/qipai_3.mp3";
	public static final String game_sound_qipai_4 = "sound/qipai_4.mp3";

    public static final String xiachouma_1 = "sound/xiachouma_1.mp3";
    public static final String xiachouma_2 = "sound/xiachouma_2.mp3";

	public static final String game_sound_yingpai = "sound/yingpai.mp3";

	public static final String game_sound_zijixingdong = "sound/zijixingdong.mp3";

	private static WeakHashMap<Long, Integer> uidIntegerMap = new WeakHashMap<>();

	public static void play(String assetsFilePath) {
		SoundPoolPlayer.playAssets(assetsFilePath);
	}

	public static void stop(String assetsFilePath) {
		SoundPoolPlayer.stopAssets(assetsFilePath);
	}


}
