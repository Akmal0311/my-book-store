package uz.yt.springdata.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Integer id;

    private String fName;

    private String lName;

    private Date bDate;
}
