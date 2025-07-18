import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OTT_PLATFORM {
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "");
        System.out.println((con != null) ? "Success" : "failed");
        System.out.println("Enter your Choice");
        System.out.println("Press 1 For User Login/Signup");
        System.out.println("Press 2 For Admin Login/signup");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Press 1 for Signup");
                System.out.println("Press 2 for Login");
                int u_choice = sc.nextInt();
                if(u_choice==1)
                {
                    System.out.println("Enter Your First Name");
                    String f_name = sc.next();
                    System.out.println("Enter Your Middle Name");
                    String m_name = sc.next();
                    System.out.println("Enter Your Last Name");
                    String l_name = sc.next();

                    long number = 0l;
                    while (true) {
                        System.out.println("Enter Your 10 Mobile Digit number ");
                        number = sc.nextLong();

                        if (number < 9999999999L && number > 6000000000L)
                            break;
                    }

                    "foh".endsWith("@gmail.com");

                    System.out.println("Enter Your Email ");
                    String email = sc.next();
                    System.out.println("Enter your Age");
                    String Age = sc.next();
                    System.out.println("Enter Your Password");
                    String password = sc.next();
                    System.out.println();
                    //user u = new user()
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Enter valid Choice");
        }

    }
}

class user {
    int user_id;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String password;
    Long mobile_no;
    int age;

    public user(int user_id, String first_name, String middle_name, String last_name, String email, String password, Long mobile_no,int age) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.mobile_no = mobile_no;
        this.age =age;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile_no=" + mobile_no +
                '}';
    }
}

class Admin {
    int admin_id;
    String admin_name;
    String email;
    String admin_password;

    public Admin(int admin_id, String admin_name, String email, String admin_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.email = email;
        this.admin_password = admin_password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", email='" + email + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}

class Movie {
    String movieId, title, language, category;
    int likes = 0, dislikes = 0;
    List<Review> reviews = new ArrayList<>();
    String videoPath;
    String duration;

    Movie(String movieId, String title, String category, String language, String videoPath, String duration) {
        this.movieId = movieId;
        this.title = title;
        this.category = category;
        this.language = language;
        this.videoPath = videoPath;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
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

class Review {
    int reviewId, userId;
    String content;
    int rating;
    Date date;

    Review(int reviewId, int userId, String content, int rating, Date date) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.content = content;
        this.rating = rating;
        this.date = date;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", date='" + date + '\'' +
                '}';
    }
}

class Subscription {
    int subId, userId;
    String planType;
    Date startDate, endDate;

    Subscription(int subId, int userId, String planType, Date startDate, Date endDate) {
        this.subId = subId;
        this.userId = userId;
        this.planType = planType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subId=" + subId +
                ", userId=" + userId +
                ", planType='" + planType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

class Histrory {
    int history_id;
    Date date;
    String time;
    int userid;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}