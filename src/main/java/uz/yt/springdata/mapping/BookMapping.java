package uz.yt.springdata.mapping;


import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.BookDTO;

import java.util.Locale;

public class BookMapping {

    public static BookDTO toDTO(Book book){
        return new BookDTO(book.getId(),
                book.getNameUz(),
                "",
                book.getCost(),
                book.getGenre());
    }


    public static Book toEntity(BookDTO bookDTO){
        return new Book(bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getCost(),
                1,
                bookDTO.getGenre());
    }

    public static void setEntity(Book book, BookDTO bookDTO){
        book.setNameUz(bookDTO.getName());
        book.setGenre(bookDTO.getGenre());
        book.setCost(bookDTO.getCost());
        book.setId(bookDTO.getId());
    }
}
