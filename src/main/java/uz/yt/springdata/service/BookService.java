package uz.yt.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.mapping.BookMapping;
import uz.yt.springdata.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public ResponseDTO<BookDTO> addNew(BookDTO bookDTO){
        try{
            Book book = BookMapping.toEntity(bookDTO);
            book.setId(null);
            bookRepository.save(book);
            return new ResponseDTO<>(true,0,"OK", BookMapping.toDTO(book));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false,-1,"ERROR IN SAVING",null);
        }
    }

    public ResponseDTO<List<BookDTO>> getAllBooks(Integer size, Integer page){
        PageRequest pageable = PageRequest.of(page,size);
        Page<Book> books = bookRepository.findAll(pageable);
        if(!books.isEmpty()) {
            List<BookDTO> response = new ArrayList<>();
            for (Book book : books) {
                response.add(BookMapping.toDTO(book));
            }
            Page<BookDTO> result = new PageImpl(response, books.getPageable(),books.getTotalElements());
            return new ResponseDTO<>(true, 0, "OK", response);
        }
        return new ResponseDTO<>(false, -1, "ERROR",null);
    }

    public ResponseDTO<BookDTO> update(BookDTO bookDTO) {
        try {
            if(bookDTO.getId() == null){
                return new ResponseDTO<>(false, -2, "ID bo'sh bo'lishi mumkin emas!",bookDTO);
            }

            Optional<Book> _book = bookRepository.findById(bookDTO.getId());
            if(!_book.isPresent()){
                return  new ResponseDTO<>(false, -3,"Bu ID bo'yicha ma'lumot mavjud emas",bookDTO);
            }

            Book book = _book.get();
            BookMapping.setEntity(book,bookDTO);

            bookRepository.save(book);

            return  new ResponseDTO<>(true, 0,"OK",bookDTO);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseDTO<>(false, -1, e.getMessage(),null);
        }

    }
}
