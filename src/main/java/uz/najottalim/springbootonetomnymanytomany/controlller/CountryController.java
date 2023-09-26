package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CountryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Country;
import uz.najottalim.springbootonetomnymanytomany.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        return ResponseEntity.ok(countryService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CountryResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<CountryResponseDto> save(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.save(country).getBody());
    }
}
