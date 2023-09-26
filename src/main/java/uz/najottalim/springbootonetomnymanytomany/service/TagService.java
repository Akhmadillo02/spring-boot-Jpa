package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.TagRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.TagResponseDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.TagResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Country;
import uz.najottalim.springbootonetomnymanytomany.model.Tag;
import uz.najottalim.springbootonetomnymanytomany.repository.TagRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagResponseDto> fndAll() {
        return maptoDto(tagRepository.findAll());
    }



    public Tag findById(Long id) {
        Optional<Tag> byId = tagRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }else {
            throw new RuntimeException(String.format("Tag  topilmadi") + id);

        }
    }


    public ResponseEntity<TagResponseDto> save(Tag tag) {
        TagResponseDto tagResponseDto = mapToDto(tagRepository.save(tag));
        return ResponseEntity.ok(tagResponseDto);
    }


    public ResponseEntity<TagResponseDto> delete(Long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (tagOptional.isPresent()) {
            tagRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Tag mapToEntity(TagRequestDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tag;
    }



    private List<TagResponseDto> maptoDto(List<Tag> tags) {
        return tags.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public TagResponseDto mapToDto(Tag tag) {
        TagResponseDto dto = new TagResponseDto();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;

    }
}
