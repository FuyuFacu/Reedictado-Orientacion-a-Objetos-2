package org.example;

public class VideoStreamAdapter extends Media {
    VideoStream video;

    public void play() {
        video.reproduce();
    }

}
