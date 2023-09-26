package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CityRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CityResponseDto;
import uz.najottalim.springbootonetomnymanytomany.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CityResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CityResponseDto>> getAll() {
        return ResponseEntity.ok(cityService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CityResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<CityResponseDto> save(@RequestBody CityRequestDto cityRequestDto) {
        return ResponseEntity.ok(cityService.save(cityRequestDto));
    }
}

