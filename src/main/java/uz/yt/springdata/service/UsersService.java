package uz.yt.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dao.Users;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UsersDTO;
import uz.yt.springdata.mapping.BookMapping;
import uz.yt.springdata.mapping.UsersMapping;
import uz.yt.springdata.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public ResponseDTO<List<UsersDTO>> getusers() {
        List<Users> users = usersRepository.findAll();
        if(!users.isEmpty()){
            List<UsersDTO> response = new ArrayList<>();
            for(Users user : users){
                response.add(UsersMapping.toDTO(user));
            }
            return new ResponseDTO<>(true, 0, "OK", response);
        }
        return new ResponseDTO<>(false, -1, "ERROR",null);
    }

    public ResponseDTO<UsersDTO> adduser(UsersDTO usersDTO) {
        try{
            Users users = UsersMapping.toEntity(usersDTO);
            usersRepository.save(users);
            return new ResponseDTO<>(true,0,"OK", UsersMapping.toDTO(users));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false,-1,"ERROR IN SAVING",null);
        }
    }
}
