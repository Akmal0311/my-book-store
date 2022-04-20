package uz.yt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UsersDTO;
import uz.yt.springdata.service.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersResource {

    private final UsersService usersService;

    @GetMapping("/get-users")
    public ResponseDTO<List<UsersDTO>> getusers(){return usersService.getusers();}

    @PostMapping("/add-user")
    public ResponseDTO<UsersDTO> adduser(@RequestBody UsersDTO usersDTO) {
        return usersService.adduser(usersDTO);
    }

}
