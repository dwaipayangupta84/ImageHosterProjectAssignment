package ImageHoster.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="comments")
public class Comment {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="text")
    private String text;

    @Column(name="created_date")
    private Date createdDate;

    //The 'comments' table is mapped to 'users' table with Many:One mapping
    //One comment can be posted by only one user (owner) but one user can post multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comments' table is mapped to 'images' table with Many:One mapping
    //One comment can belong to only one image but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() { return id;  }

    public void setId(Integer id) { this.id = id; }

    public String getText() { return text; }

    public void setText(String text) {  this.text = text;  }

    public Date getCreatedDate() { return createdDate;  }

    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate;  }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Image getImage() { return image; }

    public void setImage(Image image) { this.image = image; }
}
