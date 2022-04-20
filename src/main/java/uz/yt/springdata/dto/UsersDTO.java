package uz.yt.springdata.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

    private Integer id;

    private String fName;

    private String lName;

    private String pNumber;

    private Double account;

    private String password;

    private String uName;

}
