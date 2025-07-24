import java.util.ArrayList;
import java.util.List;

class Movie {
    int movieId;
    String  title, language, category;
    int likes = 0, dislikes = 0;
    List<Review> reviews = new ArrayList<>();
    String videoPath;
    String duration;

    public Movie(int movieId, String title, String language, String category, String videoPath, String duration, int likes, int dislikes) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
        this.category = category;
        this.videoPath = videoPath;
        this.duration = duration;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", category='" + category + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", reviews=" + reviews +
                ", videoPath='" + videoPath + '\'' +
                '}';

    }

}