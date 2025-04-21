package vn.edu.usth.doconcall.Patient.Dashboard.News_Recycler;

public class Patient_Newsfeed_Item {
    
    String title;
    String content;
    
    int feed_image;

    public Patient_Newsfeed_Item(String title, String content, int feed_image){
        this.title = title;
        this.content = content;
        this.feed_image = feed_image;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getFeed_image() {
        return feed_image;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFeed_image(int feed_image) {
        this.feed_image = feed_image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
