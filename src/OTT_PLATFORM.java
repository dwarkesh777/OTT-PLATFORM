import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class OTT_PLATFORM {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "");
        System.out.println((con != null) ? "Success" : "failed");
        HashMap<Long, user> hm = new HashMap<>();
        HashMap<Long,Admin> hmu = new HashMap<>();
        user u1 = new user(7859988312l, "d", "s", "s", "D@gmail.com", "Dwarkesh@123", 7859988312l, 18);
        hm.put(7859988312l, u1);
        System.out.println(hm);

        //dbms part
        String sql1 =" CREATE TABLE IF NOT EXISTS admin1 ( admin_id INT(10) AUTO_INCREMENT PRIMARY KEY, admin_name VARCHAR(10), admin_email VARCHAR(20), admin_password VARCHAR(8))";
        Statement st = con.createStatement();
        int r1 = st.executeUpdate(sql1);
        //  System.out.println("created user");

        String sql2 ="CREATE TABLE IF NOT EXISTS episode (episodeID INT(10) AUTO_INCREMENT PRIMARY KEY, seriesID INT(10), title VARCHAR(30)  , episodeNO INT(10), video_path LONGTEXT  , duration VARCHAR(30))";
        Statement st2 = con.createStatement();
        int r2 = st2.executeUpdate(sql2);
       // System.out.println("created episode");

        String sql3 = "CREATE TABLE IF NOT EXISTS history ( his_ID INT(10) PRIMARY KEY AUTO_INCREMENT, time VARCHAR(30), user_id INT(10), date DATE)";
        Statement st3 = con.createStatement();
        int r3 = st3.executeUpdate(sql3);
        //System.out.println("created history");

        String sql4 = "CREATE TABLE  IF NOT EXISTS login(loginID INT(10) PRIMARY KEY AUTO_INCREMENT,userID INT(10) )";
        Statement st4 = con.createStatement();
        int r4 = st3.executeUpdate(sql4);
        //System.out.println("created login");

        String sql5=" CREATE TABLE IF NOT EXISTS movie ( movie_id INT(10) PRIMARY KEY AUTO_INCREMENT , movie_title VARCHAR(20) , movie_language VARCHAR(10) , category VARCHAR(10) , video_path VARCHAR(30) , duration VARCHAR(10))";
        Statement st5 = con.createStatement();
        int r5 = st4.executeUpdate(sql5);
       // System.out.println("created movie");

        String sql6="CREATE TABLE IF NOT EXISTS review( reviewID INT(10) AUTO_INCREMENT PRIMARY KEY, userID INT(10), content VARCHAR(30) ,rating INT(10), date DATE)";
        Statement st6 = con.createStatement();
        int r6 = st.executeUpdate(sql6);
        //System.out.println("created review");

        String sql7 = "CREATE TABLE IF NOT EXISTS series (id INT(11) AUTO_INCREMENT PRIMARY KEY, title VARCHAR(30))";
        Statement st7 = con.createStatement();
        int r7 = st.executeUpdate(sql7);
       // System.out.println("created series");

        String sql8="CREATE TABLE IF NOT EXISTS Subscription_plan ( Subscription_id INT(11) AUTO_INCREMENT PRIMARY KEY, type VARCHAR(30),Start_date DATE, end_date DATE, user_id INT(11))";
        Statement st8 = con.createStatement();
        int r8 = st.executeUpdate(sql8);
        //System.out.println("created user");

        String sql9 ="CREATE TABLE IF NOT EXISTS user1 ( user_id BIGINT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(20),middle_name VARCHAR(20), last_name VARCHAR(20), email VARCHAR(50), password VARCHAR(20), mobile_no BIGINT(20))";
        Statement st9 = con.createStatement();
        int r9 = st.executeUpdate(sql9);
       // System.out.println("created subscription");


        while (true) {
            System.out.println("Enter your Choice");
            System.out.println("Press 1 For User Login/Signup");
            System.out.println("Press 2 For Admin Login/signup");
            System.out.println("Press 3 For Exit");
            int choice = sc.nextInt();

            if (choice == 3) {
                break;
            }

            if (choice == 1) {
                System.out.println("Press 1 for Signup");
                System.out.println("Press 2 for Login");
                System.out.println("Press 3 for Back");
                int u_choice = sc.nextInt();

                if (u_choice == 1) {
                    System.out.println("Enter Your First Name");
                    String f_name = sc.next();
                    System.out.println("Enter Your Middle Name");
                    String m_name = sc.next();
                    System.out.println("Enter Your Last Name");
                    String l_name = sc.next();

                    long number;
                    while (true) {
                        System.out.println("Enter Your 10 Mobile Digit number ");
                        number = sc.nextLong();
                        if (number >= 6000000000L && number <= 9999999999L)
                            break;
                        else
                            System.out.println("❌ Invalid number!");
                    }

                    String email;
                    while (true) {
                        System.out.println("Enter Your Email ");
                        email = sc.next();
                        if (email.endsWith("@gmail.com"))
                            break;
                        else
                            System.out.println("❌ Email must end with @gmail.com");
                    }

                    int age;
                    while (true) {
                        System.out.println("Enter your Age");
                        age = sc.nextInt();
                        if (age > 0)
                            break;
                    }

                    String password;
                    while (true) {
                        System.out.print("Enter your password: ");
                        password = sc.next();
                        if (password.length() < 8) {
                            System.out.println("❌ Too short.");
                            continue;
                        }

                        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

                        for (char ch : password.toCharArray()) {
                            if (Character.isUpperCase(ch)) hasUpper = true;
                            else if (Character.isLowerCase(ch)) hasLower = true;
                            else if (Character.isDigit(ch)) hasDigit = true;
                            else if ("@#$%^&*!".indexOf(ch) >= 0) hasSpecial = true;
                        }

                        if (hasUpper && hasLower && hasDigit && hasSpecial) {
                            System.out.println("✅ Strong password!");
                            break;
                        } else {
                            System.out.println("❌ Weak password.");
                        }
                    }

                    long user_id = number;
                    user u = new user(user_id, f_name, m_name, l_name, email, password, number, age);
                    hm.put(user_id, u);
                    System.out.println("User Registered: " + u);

                    String sql10 = "INSERT INTO user(user_id, first_name, middle_name, last_name, email, password, mobile_no) " +
                            "VALUES(" + user_id + ",'" + f_name + "','" + m_name + "','" + l_name + "','" + email + "','" + password + "'," + number + ")";
                    Statement s = con.createStatement();
                    s.executeUpdate(sql10);
                    System.out.println("Added in Table");
                }

                if (u_choice == 2) {
                    System.out.println("Enter Your Email:");
                    String mail = sc.next();
                    System.out.println("Enter Your Password:");
                    String pass = sc.next();
                    int otp = 100000 + new Random().nextInt(900000);
                    System.out.println("🔐 OTP Sent: " + otp);
                    System.out.print("Enter OTP: ");
                    int entered = sc.nextInt();

                    boolean found = false;
                    for (user u : hm.values()) {
                        if (u.getEmail().equals(mail) && u.getPassword().equals(pass)&&(otp==entered)) {
                            System.out.println("✅ Login successful. Welcome, " + u.getFirst_name());

                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Invalid credentials!");
                    }
                }
            }

            if (choice == 2) {
                System.out.println("⚙️ 1. Admin sign up ");
                System.out.println("⚙️ 2. Admin log in ");
                System.out.println("⚙️ 3. exit ");
                int A_choice = sc.nextInt();

                if (A_choice == 1) {
                    System.out.println("Enter full name");
                    String name = sc.next();

                    long number1;
                    while (true) {
                        System.out.println("Enter Your 10 Mobile Digit number ");
                        number1 = sc.nextLong();
                        if (number1 >= 6000000000L && number1 <= 9999999999L)
                            break;
                        else
                            System.out.println("❌ Invalid number!");
                    }

                    String email1;
                    while (true) {
                        System.out.println("Enter Your Email ");
                        email1 = sc.next();
                        if (email1.endsWith("@gmail.com"))
                            break;
                        else
                            System.out.println("❌ Email must end with @gmail.com");
                    }

                    String password1;
                    while (true) {
                        System.out.print("Enter your password: ");
                        password1 = sc.next();
                        if (password1.length() < 8) {
                            System.out.println("❌ Too short.");
                            continue;
                        }

                        boolean hasUpper1 = false, hasLower1 = false, hasDigit1 = false, hasSpecial1 = false;

                        for (char ch : password1.toCharArray()) {
                            if (Character.isUpperCase(ch)) hasUpper1 = true;
                            else if (Character.isLowerCase(ch)) hasLower1 = true;
                            else if (Character.isDigit(ch)) hasDigit1 = true;
                            else if ("@#$%^&*!".indexOf(ch) >= 0) hasSpecial1 = true;
                        }

                        if (hasUpper1 && hasLower1 && hasDigit1 && hasSpecial1) {
                            System.out.println("✅ Strong password!");
                            break;
                        } else {
                            System.out.println("❌ Weak password.");
                        }
                    }

                    long Admin_id1= number1;
                    //user u = new user(user_id, f_name, m_name, l_name, email, password, number, age);
                    //hm.put(user_id, u);
                    //System.out.println("User Registered: " + u);
                    Admin a1 = new Admin(Admin_id1,name,email1,password1);
                    String sql10 = "INSERT INTO admin " +
                            "VALUES(" + Admin_id1 + ",'" + name + "','" + email1 + "','" + password1 + "')";
                    Statement s = con.createStatement();
                    s.executeUpdate(sql10);
                    System.out.println("Added in Table");
                }

                if (A_choice == 2) {
                    System.out.println("Enter Your Email:");
                    String mail1 = sc.next();
                    System.out.println("Enter Your Password:");
                    String pass1 = sc.next();
                    int otp = 100000 + new Random().nextInt(900000);
                    System.out.println("🔐 OTP Sent: " + otp);
                    System.out.print("Enter OTP: ");
                    int entered = sc.nextInt();

                    boolean found = false;
                    for (Admin a : hmu.values()) {
                        if (a.getEmail().equals(mail1) && a.getAdmin_password().equals(pass1)&&(otp==entered)) {
                            System.out.println("✅ Login successful. Welcome, " + a.admin_name);

                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Invalid credentials!");
                    }
            }
        }

    }
}}
class user {
    long user_id;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String password;
    Long mobile_no;
    int age;

    public user(long user_id, String first_name, String middle_name, String last_name, String email, String password, Long mobile_no, int age) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.mobile_no = mobile_no;
        this.age = age;
    }

    public user(String userId, String d, String s, String s1, String mail) {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
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
        return "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile_no=" + mobile_no
                ;
    }
}

class Admin {
    long admin_id;
    String admin_name;
    String email;
    String admin_password;

    public Admin(long admin_id, String admin_name, String email, String admin_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.email = email;
        this.admin_password = admin_password;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
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