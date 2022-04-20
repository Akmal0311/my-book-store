package uz.yt.springdata.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;
}
