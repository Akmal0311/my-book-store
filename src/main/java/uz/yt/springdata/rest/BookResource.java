package uz.yt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookResource {


    private final BookService bookService;

    @GetMapping("/get-all")
    public ResponseDTO<List<BookDTO>> getAll(){
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseDTO<BookDTO> add(@RequestBody BookDTO bookDTO){
        return bookService.addNew(bookDTO);
    }

    @PutMapping("/update")
    public ResponseDTO<BookDTO> update(@RequestBody BookDTO bookDTO){
        return bookService.update(bookDTO);
    }

    @DeleteMapping("/delete")
    public ResponseDTO<BookDTO> delete(@RequestBody BookDTO bookDTO){
        return bookService.delete(bookDTO);
    }

}
