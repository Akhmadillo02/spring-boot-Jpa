package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.response.TagResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Tag;
import uz.najottalim.springbootonetomnymanytomany.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Tag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<TagResponseDto>> getAll() {
        return ResponseEntity.ok(tagService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TagResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<TagResponseDto> save(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.save(tag).getBody());
    }
}
