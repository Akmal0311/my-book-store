package uz.yt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.ResponseDTO;
import uz.yt.springdata.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("{lang}")
public class BookResource {


    private final BookService bookService;

    @GetMapping("/get-all")
    public ResponseDTO<List<BookDTO>> getAll(@PathVariable String lang,@RequestParam Integer size, @RequestParam Integer page){
        return bookService.getAllBooks(size, page);
    }

    @PostMapping("/add")
    public ResponseDTO<BookDTO> add(@RequestBody BookDTO bookDTO, @PathVariable String lang){
        return bookService.addNew(bookDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseDTO<Book> put(@PathVariable Integer id, @RequestBody BookDTO bookDTO, @PathVariable String lang){
        Book book = new Book(1,"O`tgan kunlar",123000D,1,"badiy");
        book.setId(id);
        book.setNameUz(bookDTO.getName());
        book.setCost(bookDTO.getCost());
        book.setGenre(bookDTO.getGenre());
        return new ResponseDTO<>(true,0,"OK",book);
    }

    @PutMapping("/update")
    public ResponseDTO<BookDTO> update(@RequestBody BookDTO bookDTO, @PathVariable String lang){
        return bookService.update(bookDTO);
    }


}
