/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package org.mangui.basic {
    import org.mangui.hls.HLS;
    import org.mangui.hls.event.HLSEvent;

    import flash.display.Sprite;
    import flash.media.Video;

    public class Player extends Sprite {
        private var hls : HLS = null;
        private var video : Video = null;

        public function Player() {
            hls = new HLS();
            hls.stage = this.stage;
            video = new Video(640, 480);
            addChild(video);
            video.x = 0;
            video.y = 0;
            video.smoothing = true;
            video.attachNetStream(hls.stream);
            hls.addEventListener(HLSEvent.MANIFEST_LOADED, manifestHandler);
            hls.load("http://pl.youku.com/playlist/m3u8?ts=1420547730&keyframe=0&vid=XNTUzMDQzODky&type=hd2&ep=eyaWGkyJXscF7STcjT8bZCrhfXYMXJZ0knrP%2FKYDSsRQE6HQmjfVxg%3D%3D&sid=942054895873512363913&token=3941&ctype=12&ev=1&oip=3663591661");
        }

        public function manifestHandler(event : HLSEvent) : void {
			trace(event);
            hls.stream.play(null, -1);
        };
    }
}
