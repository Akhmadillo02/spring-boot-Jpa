package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.BookRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.BookResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Book;
import uz.najottalim.springbootonetomnymanytomany.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public List<BookResponseDto> fndAll() {
        return maptoDto(bookRepository.findAll());
    }


    public BookResponseDto findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            BookResponseDto dto = mapToDto(book);
            return dto;
        } else {
            return null;

        }
    }

    public ResponseEntity<BookResponseDto> delete(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<BookResponseDto> save(Book book) {
        BookResponseDto bookResponseDto = mapToDto(bookRepository.save(book));
        return ResponseEntity.ok(bookResponseDto);
    }

    public Book mapToEntity(BookRequestDto dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        book.setPublisherDate(dto.getPublisherDate());
        return book;
    }




    private List<BookResponseDto> maptoDto(List<Book> books) {
        return books.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());
        dto.setPublisherDate(book.getPublisherDate());
        dto.setTagId(book.getTags().get(0).getId());
        dto.setCityId(book.getCategories().get(0).getId());
        return dto;
    }
}
