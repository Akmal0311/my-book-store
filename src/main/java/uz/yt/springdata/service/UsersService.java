package uz.yt.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.yt.springdata.dao.Users;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.dto.UsersDTO;
import uz.yt.springdata.mapping.UsersMapping;
import uz.yt.springdata.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public ResponseDTO<List<UsersDTO>> getusers(Integer size, Integer page) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Users> usersPage = usersRepository.findAll(pageRequest);
            List<UsersDTO> userDTO = new ArrayList<>();
            for (Users user : usersPage) {
                userDTO.add(UsersMapping.toDTO(user));
            }
            return new ResponseDTO<>(true, 0, "OK", userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "CONFLICT IN DATA", null);
        }
    }

    public ResponseDTO<UsersDTO> adduser(UsersDTO usersDTO) {
        try{
            Users users = UsersMapping.toEntity(usersDTO);
            users.setId(null);
            usersRepository.save(users);
            return new ResponseDTO<>(true,0,"OK", UsersMapping.toDTO(users));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false,-1,"ERROR IN SAVING!",null);
        }
    }

    public ResponseDTO<UsersDTO> update(UsersDTO usersDTO) {
        try{
            Users users = UsersMapping.toEntity(usersDTO);
            usersRepository.save(users);
            UsersMapping.setEntity(users,usersDTO);
            return new ResponseDTO<>(true, 0, "OK",usersDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "ERROR IN SAVING!",null);
        }
    }

    public ResponseDTO<UsersDTO> delete(UsersDTO usersDTO){
        return null;
    }
}
