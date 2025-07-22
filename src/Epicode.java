class Episode {
    int episodeId;
    int seriesId;
    String title;
    int episodeNo;
    String videoPath, duration;

    Episode(int episodeId, int seriesId, String title, int episodeNo, String videoPath, String duration) {
        this.episodeId = episodeId;
        this.seriesId = seriesId;
        this.title = title;
        this.episodeNo = episodeNo;
        this.videoPath = videoPath;
        this.duration = duration;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = Integer.parseInt(episodeId);
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeNo() {
        return episodeNo;
    }

    public void setEpisodeNo(int episodeNo) {
        this.episodeNo = episodeNo;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeId=" + episodeId +
                ", seriesId=" + seriesId +
                ", title='" + title + '\'' +
                ", episodeNo=" + episodeNo +
                ", videoPath='" + videoPath + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}