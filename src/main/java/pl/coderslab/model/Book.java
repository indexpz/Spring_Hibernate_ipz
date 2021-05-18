package pl.coderslab.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title", length = 100, nullable = false)
    String title;

    @Column(name = "author", length = 100, nullable = false)
    String author;

    @Column(scale=2, precision=4, nullable = true)
    int rating;

    @Column(length = 255, nullable = true)
    String description;

//    @Column(name = "created_on")
//    private LocalDateTime createdOn;
//
//    @Column(name = "updated_on")
//    private LocalDateTime updatedOn;
//
//    @PrePersist
//    public void prePersist() {
//        createdOn = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updatedOn = LocalDateTime.now();
//    }



//    gettery i settery


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
