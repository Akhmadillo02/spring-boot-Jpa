package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.response.PublisherResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Publisher;
import uz.najottalim.springbootonetomnymanytomany.service.PublisherService;

import java.util.List;

@RestController
@RequestMapping ("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<PublisherResponseDto>> getAll() {
        return ResponseEntity.ok(publisherService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PublisherResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<PublisherResponseDto> save(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(publisherService.save(publisher).getBody());
    }
}
