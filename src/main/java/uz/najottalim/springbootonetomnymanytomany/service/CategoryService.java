package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CategoryRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CountryRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CategoryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CategoryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Category;
import uz.najottalim.springbootonetomnymanytomany.model.Country;
import uz.najottalim.springbootonetomnymanytomany.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> fndAll() {
        return maptoDto(categoryRepository.findAll());
    }



    public Category findById(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }else {
            throw new RuntimeException(String.format("Category  topilmadi") + id);

        }
    }


    public ResponseEntity<CategoryResponseDto> save(Category category) {
        CategoryResponseDto categoryResponseDto = mapToDto(categoryRepository.save(category));
        return ResponseEntity.ok(categoryResponseDto);
    }


    public ResponseEntity<CategoryResponseDto> delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Category mapToEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setBook(dto.getBookId());
        return category;
    }



    private List<CategoryResponseDto> maptoDto(List<Category> categories) {
        return categories.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public CategoryResponseDto mapToDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setBookId(category.getBook().getId());
        return dto;

    }
}
