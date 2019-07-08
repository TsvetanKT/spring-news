package tsvetankt.newsapplication.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewsArticle {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String date;
    
    private String title;
    
    private String description;
    
    private String text;

    public NewsArticle() {}

    public NewsArticle(String date, String title, String description, String text) {
        this(0, date, title, description, text);
    }
    
    public NewsArticle(int id, String date, String title, String description, String text) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
