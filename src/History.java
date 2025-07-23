import java.util.Date;

class Histrory {
    int history_id;
    String date;
    String time;
    int userid;
    String content;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public Histrory(int history_id, String date, String time, int userid, String content) {
        this.history_id = history_id;
        this.date = date;
        this.time = time;
        this.userid = userid;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Histrory{" +
                "history_id=" + history_id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                '}';
    }
}