package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.request.BookRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CityRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.BookResponseDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CityResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Book;
import uz.najottalim.springbootonetomnymanytomany.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponseDto> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book).getBody());
    }
}
