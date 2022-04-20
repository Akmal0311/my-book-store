package uz.yt.springdata.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="newBook")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="nameuz")
    private String nameUz;

    @Column(name="cost")
    private Double cost;

    @Column(name="published_date")
    private Date publishedDate;

    @Column(name="page_count")
    private Integer pageCount;

    @Column(name="author_id")
    private Integer authorId;

    @Column(name="genre")
    private String genre;

    @Column(name="publisher_id")
    private Integer publisherId;


    public Book(Integer id, String nameUz, Double cost, Integer authorId, String genre) {
        this.id = id;
        this.nameUz = nameUz;
        this.cost = cost;
        this.authorId = authorId;
        this.genre = genre;
    }
}
