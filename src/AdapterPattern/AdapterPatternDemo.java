package AdapterPattern;

/**
 * @author xuyp 适配器模式 场景类比 Android 和 iPhone 的充电器转换头
 */
public class AdapterPatternDemo {
	public static void main(String agrs[]) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3");
		audioPlayer.play("vlc");
		audioPlayer.play("mp4");
		audioPlayer.play("3D");
	}
}

interface Mp4AndVlcMediaPlayer {// mp4 和 vlc播放器接口
	public void mp4();

	public void vlc();
}

class MP4Player implements Mp4AndVlcMediaPlayer {// mp4播放器
	@Override
	public void mp4() {
		System.out.println("play mp4");
	}

	@Override
	public void vlc() {
	}
}

class VLCPlayer implements Mp4AndVlcMediaPlayer {// vlc播放器

	@Override
	public void mp4() {
	}

	@Override
	public void vlc() {
		System.out.println("paly VLC");
	}
}

/*
 * 现在要能播放MP3的播放器也能播放MP4及VLC，那么加一个适配器
 */
interface MediaPlay {
	public void play(String s);
}

class AudioPlayer implements MediaPlay {

	@Override
	public void play(String s) {
		if ("mp3".equals(s)) {
			System.out.println("play mp3");
		} else if ("mp4".equals(s) || "vlc".equals(s)) {// 通适配器来播放MP4和vlc格式
			MediaPlay madaper = new MediaPlayAdapter(s);
			madaper.play(s);
		} else {
			System.out.println("not supported!");
		}
	}
}

class MediaPlayAdapter implements MediaPlay {// 适配器
	private Mp4AndVlcMediaPlayer mp4AndVlcMediaPlayer;

	public MediaPlayAdapter(String s) {
		if ("mp4".equals(s)) {
			mp4AndVlcMediaPlayer = new MP4Player();
		}
		if ("vlc".equals(s)) {
			mp4AndVlcMediaPlayer = new VLCPlayer();
		}
	}

	@Override
	public void play(String s) {
		if ("mp4".equals(s)) {
			this.mp4AndVlcMediaPlayer.mp4();
		}
		if ("vlc".equals(s)) {
			this.mp4AndVlcMediaPlayer.vlc();
		}
	}
}
