package uz.yt.springdata.mapping;


import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dao.Users;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.UsersDTO;

public class UsersMapping {

    public static UsersDTO toDTO(Users users){
        return new UsersDTO(users.getId(),
                users.getFirstName(),
                users.getLastName(),
                users.getPhoneNumber(),
                users.getAcc(),
                users.getPass(),
                users.getUserName());
    }

    public static Users toEntity(UsersDTO usersDTO){
        return new Users(usersDTO.getId(),
                usersDTO.getFName(),
                usersDTO.getLName(),
                usersDTO.getPNumber(),
                usersDTO.getAccount(),
                usersDTO.getPassword(),
                usersDTO.getUName());
    }

    public static void setEntity(Users users, UsersDTO usersDTO){
        users.setId(usersDTO.getId());
        users.setFirstName(usersDTO.getFName());
        users.setLastName(usersDTO.getLName());
        users.setPhoneNumber(usersDTO.getPNumber());
        users.setAcc(usersDTO.getAccount());
        users.setPass(usersDTO.getPassword());
        users.setUserName(usersDTO.getUName());
    }
}
