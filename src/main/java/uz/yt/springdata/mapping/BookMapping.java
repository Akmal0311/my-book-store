package uz.yt.springdata.mapping;


import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.AuthorDTO;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.PublisherDTO;


public class BookMapping {

    public static BookDTO toDTO(Book book){
        AuthorDTO authorDTO = new AuthorDTO();
        PublisherDTO publisherDTO = new PublisherDTO();
        return new BookDTO(book.getId(),
                book.getNameUz(),
                book.getCost(),
                book.getPublishedDate(),
                book.getPageCount(),
                authorDTO,
                book.getGenre(),
                publisherDTO);
    }


    public static Book toEntity(BookDTO bookDTO){
        return new Book(bookDTO.getId(),
                bookDTO.getName(),
                bookDTO.getCost(),
                bookDTO.getPublished_date(),
                bookDTO.getPageCount(),
                bookDTO.getGenre());
    }

    public static void setEntity(Book book, BookDTO bookDTO){
        book.setId(bookDTO.getId());
        book.setNameUz(bookDTO.getName());
        book.setCost(bookDTO.getCost());
        book.setPublishedDate(bookDTO.getPublished_date());
        book.setPageCount(bookDTO.getPageCount());
        book.setAuthorId(bookDTO.getAuthor().getId());
        book.setGenre(bookDTO.getGenre());
        book.setPublisherId(bookDTO.getPublisher().getId());
    }
}
