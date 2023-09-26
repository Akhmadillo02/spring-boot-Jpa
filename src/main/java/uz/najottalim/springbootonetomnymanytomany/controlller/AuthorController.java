package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.request.AuthorRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CityRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.AuthorResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Author;
import uz.najottalim.springbootonetomnymanytomany.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AuthorResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorResponseDto>> getAll() {
        return ResponseEntity.ok(authorService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<AuthorResponseDto> save(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.save(author).getBody());
    }
}
