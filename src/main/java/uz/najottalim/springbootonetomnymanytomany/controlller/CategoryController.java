package uz.najottalim.springbootonetomnymanytomany.controlller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CategoryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Category;
import uz.najottalim.springbootonetomnymanytomany.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        return ResponseEntity.ok(categoryService.fndAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponseDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.delete(id)).getBody();
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResponseDto> save(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category).getBody());
    }
}
