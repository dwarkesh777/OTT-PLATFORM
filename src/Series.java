    import java.util.ArrayList;
    import java.util.List;
        class Series {
        int seriesId;
        String title, genre;
        int total_episode;
        List<Episode> episodes = new ArrayList<>();

        Series(int seriesId, String title, String genre, int total_episode) {
            this.seriesId = seriesId;
            this.title = title;
            this.genre = genre;
            this.total_episode = total_episode;
        }

        public int getSeriesId() {
            return seriesId;
        }

        public int setSeriesId(int seriesId) {
            return seriesId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getTotal_episode() {
            return total_episode;
        }

        public void setTotal_episode(int total_episode) {
            this.total_episode = total_episode;
        }

        public List<Episode> getEpisodes() {
            return episodes;
        }

        public void setEpisodes(List<Episode> episodes) {
            this.episodes = episodes;
        }

        @Override
        public String toString() {
            return "Series{" +
                    "seriesId='" + seriesId + '\'' +
                    ", title='" + title + '\'' +
                    ", genre='" + genre + '\'' +
                    ", episode_no=" + total_episode +
                    ", episodes=" + episodes +
                    '}';
        }
    }


