package uz.yt.springdata.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "account")
    private Double acc;

    @Column(name = "password")
    private String pass;

    @Column(name = "username")
    private String userName;

    public Users(Integer id, String firstName, String lastName, String phoneNumber, Double acc, String pass, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.acc = acc;
        this.pass = pass;
        this.userName = userName;
    }
}
