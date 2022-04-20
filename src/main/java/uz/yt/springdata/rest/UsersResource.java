package uz.yt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UsersDTO;
import uz.yt.springdata.service.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersResource {

    private final UsersService usersService;

    @GetMapping("/get-users")
    public ResponseDTO<List<UsersDTO>> getusers(@RequestParam Integer size, @RequestParam Integer page){
        return usersService.getusers(size, page);}

    @PostMapping("/add-user")
    public ResponseDTO<UsersDTO> adduser(@RequestBody UsersDTO usersDTO) {
        return usersService.adduser(usersDTO);
    }

    @PutMapping("/upadate-user")
    public ResponseDTO<UsersDTO> update(@RequestBody UsersDTO usersDTO){
        return usersService.update(usersDTO);
    }

    @DeleteMapping("delete-user")
    public ResponseDTO<UsersDTO> delete(@RequestBody UsersDTO usersDTO){
        return usersService.delete(usersDTO);
    }

}
