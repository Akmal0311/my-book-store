package uz.yt.springdata.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Integer id;

    private String name;

    private Double cost;

    private Date published_date;

    private Integer pageCount;

    private AuthorDTO author;

    private String genre;

    private PublisherDTO publisher;



    public String toString() {
        return String.format("%d-kitob: \nNomi: %s \nNarxi: %.2f \nJanri: %s \nMuallif: %s",id,name,cost,genre,author);
    }
}
