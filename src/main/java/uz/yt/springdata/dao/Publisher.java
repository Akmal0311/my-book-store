package uz.yt.springdata.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address_id")
    private Integer addId;

    public Publisher(Integer id, String name, Integer addId) {
        this.id = id;
        this.name = name;
        this.addId = addId;
    }
}
