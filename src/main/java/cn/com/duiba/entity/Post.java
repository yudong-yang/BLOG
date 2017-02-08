package cn.com.duiba.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
	private static int count = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min=2, max=30)
    private String title;

    @Size(min=1)
    private String content;

    private Date created = new Date();
    
    private Date updated = new Date();
    
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post(String title, String content) {
        this.id = count++;
        this.title = title;
        this.content = content;
        this.created = new Date();
        this.updated = new Date();
        
    }
    public Post() {
    }
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}