import java.sql.*;
import java.util.*;
import java.util.Date;

public class OTT_PLATFORM {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ott", "root", "");
        System.out.println((con != null) ? "Success" : "failed");
        HashMap<Long, user> hm = new HashMap<>();
        HashMap<Long, Admin> hmu = new HashMap<>();
        user u1 = new user(7859988312l, "d", "s", "s", "D@gmail.com", "Dwarkesh@123", 7859988312l, 18);
        hm.put(7859988312l, u1);
        System.out.println(hm);

        //dbms part
        String sql1 = " CREATE TABLE IF NOT EXISTS admin ( admin_id BIGINT(100) AUTO_INCREMENT PRIMARY KEY, admin_name VARCHAR(10), admin_email VARCHAR(20), admin_password VARCHAR(15))";
        Statement st = con.createStatement();
        int r1 = st.executeUpdate(sql1);
        // System.out.println("created user");

        String sql2 = "CREATE TABLE IF NOT EXISTS episode (episodeID INT(10) AUTO_INCREMENT PRIMARY KEY, seriesID INT(10), title VARCHAR(30)  , episodeNO INT(10), video_path LONGTEXT  , duration VARCHAR(30))";
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

        String sql5 = " CREATE TABLE IF NOT EXISTS movie ( movie_id INT(10) PRIMARY KEY AUTO_INCREMENT , movie_title VARCHAR(20) , movie_language VARCHAR(10) , category VARCHAR(10) , video_path VARCHAR(30) , duration VARCHAR(10))";
        Statement st5 = con.createStatement();
        int r5 = st4.executeUpdate(sql5);
        // System.out.println("created movie");

        String sql6 = "CREATE TABLE IF NOT EXISTS review( reviewID INT(10) AUTO_INCREMENT PRIMARY KEY, userID INT(10), content VARCHAR(30) ,rating INT(10), date DATE)";
        Statement st6 = con.createStatement();
        int r6 = st.executeUpdate(sql6);
        //System.out.println("created review");

        String sql7 = "CREATE TABLE IF NOT EXISTS series (id INT(11) AUTO_INCREMENT PRIMARY KEY, title VARCHAR(30))";
        Statement st7 = con.createStatement();
        int r7 = st.executeUpdate(sql7);
        // System.out.println("created series");

        String sql8 = "CREATE TABLE IF NOT EXISTS Subscription_plan ( Subscription_id INT(11) AUTO_INCREMENT PRIMARY KEY, type VARCHAR(30),Start_date DATE, end_date DATE, user_id INT(11))";
        Statement st8 = con.createStatement();
        int r8 = st.executeUpdate(sql8);
        //System.out.println("created user");

        String sql9 = "CREATE TABLE IF NOT EXISTS user ( user_id BIGINT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(20),middle_name VARCHAR(20), last_name VARCHAR(20), email VARCHAR(50), password VARCHAR(20), mobile_no BIGINT(20))";
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
                        if (u.getEmail().equals(mail) && u.getPassword().equals(pass) && (otp == entered)) {
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
                while (true) {
                    System.out.println("⚙ 1. Admin sign up ");
                    System.out.println("⚙ 2. Admin log in ");
                    System.out.println("⚙ 3. Exit ");
                    System.out.print("Enter your choice: ");
                    int A_choice = sc.nextInt();

                    if (A_choice == 1) {
                        // ✅ Admin Signup
                        System.out.println("Enter full name:");
                        String name = sc.next();

                        long number1;
                        while (true) {
                            System.out.println("Enter Your 10-digit Mobile Number: ");
                            number1 = sc.nextLong();
                            if (number1 >= 6000000000L && number1 <= 9999999999L)
                                break;
                            else
                                System.out.println("❌ Invalid number!");
                        }

                        String email1;
                        while (true) {
                            System.out.println("Enter Your Email: ");
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

                        long Admin_id1 = number1;
                        Admin a1 = new Admin(Admin_id1, name, email1, password1);
                        hmu.put(Admin_id1, a1);

                        // Insert into DB
                        try {
                            String sql10 = "INSERT INTO admin VALUES(" + Admin_id1 + ",'" + name + "','" + email1 + "','" + password1 + "')";
                            Statement s = con.createStatement();
                            s.executeUpdate(sql10);
                            System.out.println("✅ Admin Registered & Added to DB.");
                        } catch (Exception e) {
                            System.out.println("❌ Error inserting into admin table: " + e.getMessage());
                        }
                    } else if (A_choice == 2) {
                        // ✅ Load admins from DB first
                        hmu.clear();
                        try {
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
                            while (rs.next()) {
                                long id = rs.getLong("admin_id");
                                String name = rs.getString("admin_name");
                                String email = rs.getString("admin_email");
                                String password = rs.getString("admin_password");
                                Admin adminObj = new Admin(id, name, email, password);
                                hmu.put(id, adminObj);
                            }
                        } catch (Exception e) {
                            System.out.println("❌ Error loading admin data: " + e.getMessage());
                        }

                        // 🧠 Login Logic
                        System.out.println("Enter Your Email:");
                        String mail1 = sc.next();
                        System.out.println("Enter Your Password:");
                        String pass1 = sc.next();

                        int otp2 = 100000 + new Random().nextInt(900000);
                        System.out.println("🔐 OTP Sent: " + otp2);
                        System.out.print("Enter OTP: ");
                        int entered = sc.nextInt();

                        boolean found = false;
                        for (Admin a1 : hmu.values()) {
                            if (a1.getEmail().equals(mail1) && a1.getAdmin_password().equals(pass1) && otp2 == entered) {
                                System.out.println("✅ Login successful. Welcome, " + a1.admin_name);
                                while (true) {
                                    System.out.println("\n-----MOVIES-----");
                                    System.out.println("1.insert movie");
                                    System.out.println("2.update movie");
                                    System.out.println("3.delete movie");
                                    System.out.println("4.view all movies");
                                    System.out.println("5.exit");

                                    int moviechoice = sc.nextInt();
                                    if (moviechoice == 5) {
                                        break;
                                    }

                                    if (moviechoice == 1) {
                                        String[][] movies = {
                                                {"Jawan", "Hindi", "Action", "C:/Movies/jawan.mp4", "2h45m"},
                                                {"RRR", "Telugu", "Drama", "C:/Movies/rrr.mp4", "3h07m"},
                                                {"KGF", "Kannada", "Action", "C:/Movies/kgf.mp4", "2h35m"},
                                                {"Pathaan", "Hindi", "Spy", "C:/Movies/pathaan.mp4", "2h40m"},
                                                {"Dangal", "Hindi", "Biopic", "C:/Movies/dangal.mp4", "2h49m"},
                                                {"Bahubali", "Telugu", "Epic", "C:/Movies/bahubali.mp4", "2h58m"},
                                                {"Pushpa", "Telugu", "Action", "C:/Movies/pushpa.mp4", "2h59m"},
                                                {"Drishyam", "Malayalam", "Thriller", "C:/Movies/drishyam.mp4", "2h45m"},
                                                {"Vikram", "Tamil", "Action", "C:/Movies/vikram.mp4", "2h47m"},
                                                {"Master", "Tamil", "Drama", "C:/Movies/master.mp4", "2h43m"},
                                                {"3 Idiots", "Hindi", "Comedy", "C:/Movies/3idiots.mp4", "2h51m"},
                                                {"Shershaah", "Hindi", "War", "C:/Movies/shershaah.mp4", "2h18m"},
                                                {"Article 15", "Hindi", "Crime", "C:/Movies/article15.mp4", "2h10m"},
                                                {"Kantara", "Kannada", "Mystery", "C:/Movies/kantara.mp4", "2h27m"},
                                                {"Gully Boy", "Hindi", "Musical", "C:/Movies/gullyboy.mp4", "2h34m"},
                                                {"Lagaan", "Hindi", "Historical", "C:/Movies/lagaan.mp4", "3h44m"},
                                                {"Sita Ramam", "Telugu", "Romance", "C:/Movies/sitaramam.mp4", "2h30m"},
                                                {"Dil Bechara", "Hindi", "Romance", "C:/Movies/dilbechara.mp4", "1h41m"},
                                                {"URI", "Hindi", "War", "C:/Movies/uri.mp4", "2h18m"},
                                                {"Raazi", "Hindi", "Spy", "C:/Movies/raazi.mp4", "2h20m"},
                                                {"Chhichhore", "Hindi", "Drama", "C:/Movies/chhichhore.mp4", "2h23m"},
                                                {"The Kashmir Files", "Hindi", "Drama", "C:/Movies/kashmirfiles.mp4", "2h50m"},
                                                {"Rocketry", "Hindi", "Biopic", "C:/Movies/rocketry.mp4", "2h38m"},
                                                {"Super 30", "Hindi", "Biography", "C:/Movies/super30.mp4", "2h34m"},
                                                {"Andhadhun", "Hindi", "Thriller", "C:/Movies/andhadhun.mp4", "2h19m"}
                                        };

                                        for (String[] m : movies) {
                                            String insertMovieSQL = "INSERT INTO movie (movie_title, movie_language, category, video_path, duration) " +
                                                    "VALUES('" + m[0] + "','" + m[1] + "','" + m[2] + "','" + m[3] + "','" + m[4] + "')";
                                            Statement stmt = con.createStatement();
                                            stmt.executeUpdate(insertMovieSQL);
                                        }

                                        System.out.println("✅ 25 Predefined Movies Inserted Successfully!");
                                    } else if (moviechoice == 2) {
                                        System.out.print("Enter movie ID to update: ");
                                        int movieIdToUpdate = sc.nextInt();
                                        sc.nextLine(); // Consume newline

                                        System.out.print("Enter new movie title: ");
                                        String newTitle = sc.nextLine();

                                        String updateSQL = "UPDATE movie SET movie_title = ? WHERE movie_id = ?";
                                        PreparedStatement pstmt = con.prepareStatement(updateSQL);
                                        pstmt.setString(1, newTitle);
                                        pstmt.setInt(2, movieIdToUpdate);

                                        int rows = pstmt.executeUpdate();

                                        if (rows > 0)
                                            System.out.println("✅ Movie ID " + movieIdToUpdate + " updated to: " + newTitle);
                                        else
                                            System.out.println("❌ Movie ID not found.");
                                    } else if (moviechoice == 3) {
                                        System.out.print("Enter movie ID to delete: ");
                                        int movieIdToDelete = sc.nextInt();

                                        String deleteSQL = "DELETE FROM movie where movie_id=?";
                                        PreparedStatement pst = con.prepareStatement(deleteSQL);
                                        pst.setInt(1, movieIdToDelete);

                                        int r = pst.executeUpdate();

                                        if (r > 0) {
                                            System.out.println("✅ Movie ID " + movieIdToDelete + " Deleted");
                                        } else {
                                            System.out.println("❌ Movie ID not found. ");
                                        }
                                    } else if (moviechoice == 4) {
                                        String fetchSQL = "SELECT * FROM movie";
                                        Statement stmt = con.createStatement();
                                        ResultSet rs = stmt.executeQuery(fetchSQL);

                                        System.out.println("\n🎥 Movie List:");
                                        System.out.println("---------------------------------------------------------");

                                        while (rs.next()) {
                                            int id = rs.getInt("movie_id");
                                            String title = rs.getString("movie_title");
                                            String lang = rs.getString("movie_language");
                                            String cat = rs.getString("category");
                                            String dur = rs.getString("duration");

                                            System.out.println("Movie ID : " + id);
                                            System.out.println("Title : " + title);
                                            System.out.println("language : " + lang);
                                            System.out.println("categoty : " + cat);
                                            System.out.println("duration : " + dur);
                                            System.out.println("---------------------------------------------------------");
                                        }
                                    } else if (moviechoice==5) {
                                        System.out.println("Exiting");
                                        break;
                                    }
                                }
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("❌ Invalid credentials or OTP!");
                        }
                    } else if (A_choice == 3) {
                        break;
                    } else {
                        System.out.println("❌ Invalid choice. Try again.");
                    }
                }

            }


        }

    }


}
