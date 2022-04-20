package uz.yt.springdata.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    private Integer id;

    private String name;

    private Integer addressId;
}
