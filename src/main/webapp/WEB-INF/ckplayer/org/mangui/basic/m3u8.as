package org.mangui.basic {
	
	import org.mangui.hls.event.HLSEvent;
	import org.mangui.hls.HLS;
	import flash.media.Video;
	import flash.display.Sprite;
	
	
	public class m3u8 extends Sprite {
		
		
		private var hls:HLS = null;
		private var video:Video = null;
		public function m3u8() {
			hls = new HLS();
			hls.stage=this.stage;
			video = new Video(640, 480);
			this.addChild(video);
			video.x = 0;
			video.y = 0;
			video.smoothing = true;
			video.attachNetStream(hls.stream);
			hls.addEventListener(HLSEvent.MANIFEST_LOADED, manifestHandler); //加载成功
			//hls.addEventListener(HLSEvent.FRAGMENT_LOADED, fragmentHandler);
			//hls.addEventListener(HLSEvent.ERROR,errorHandler);//加载失败
			//hls.addEventListener(HLSEvent.MEDIA_TIME,mediaTimeHandler);//播放时间
			hls.load("http://pl.youku.com/playlist/m3u8?ts=1420547730&keyframe=0&vid=XNTUzMDQzODky&type=hd2&ep=eyaWGkyJXscF7STcjT8bZCrhfXYMXJZ0knrP%2FKYDSsRQE6HQmjfVxg%3D%3D&sid=942054895873512363913&token=3941&ctype=12&ev=1&oip=3663591661");
		}
		private function manifestHandler(event:HLSEvent): void {
			hls.stream.play(null, -1);
		}
	}
	
}
