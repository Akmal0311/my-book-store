package uz.yt.springdata.mapping;

import uz.yt.springdata.dao.Author;
import uz.yt.springdata.dto.AuthorDTO;

public class AuthorMapping {

    public static AuthorDTO toDTO(Author author){
        return new AuthorDTO(author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBirthDate());
    }

    public static Author toEntity(AuthorDTO authorDTO){
        return new Author(authorDTO.getId(),
                authorDTO.getFName(),
                authorDTO.getLName(),
                authorDTO.getBDate());
    }

    public static void setEntity(Author author, AuthorDTO authorDTO){
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFName());
        author.setLastName(authorDTO.getLName());
        author.setBirthDate(authorDTO.getBDate());
    }
}
