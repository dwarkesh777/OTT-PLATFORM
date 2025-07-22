import java.util.Date;

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
