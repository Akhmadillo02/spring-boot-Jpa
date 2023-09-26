package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.AuthorRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.AuthorResponseDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CategoryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Author;
import uz.najottalim.springbootonetomnymanytomany.model.Category;
import uz.najottalim.springbootonetomnymanytomany.model.City;
import uz.najottalim.springbootonetomnymanytomany.repository.AuthorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final CityService cityService;

    public AuthorService(AuthorRepository authorRepository, CityService cityService) {
        this.authorRepository = authorRepository;
        this.cityService = cityService;
    }


    public List<AuthorResponseDto> fndAll() {
        return maptoDto(authorRepository.findAll());
    }




    public AuthorResponseDto findById(Long id) {
        Optional<Author> authorOptional= authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            AuthorResponseDto dto = mapToDto1(author);
            return dto;
        } else {
            return null;

        }
    }

    public ResponseEntity<AuthorResponseDto> delete(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<AuthorResponseDto> save(Author author) {
        AuthorResponseDto authorResponseDto = mapToDto(authorRepository.save(author));
        return ResponseEntity.ok(authorResponseDto);
    }

    public Author mapToEntity(AuthorRequestDto dto) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setEmail(dto.getEmail());
        author.setCity(dto.getCityId());
        return author;
    }


    public AuthorResponseDto mapToDto1(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setEmail(author.getEmail());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setCityId(author.getCity().getId());
        return dto;
    }

    private List<AuthorResponseDto> maptoDto(List<Author> authors) {
        return authors.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setCityId(author.getCity().getId());
        return dto;
    }
}
