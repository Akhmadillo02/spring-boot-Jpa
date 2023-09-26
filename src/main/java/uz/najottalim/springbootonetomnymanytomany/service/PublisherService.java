package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.PublisherRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.PublisherResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Publisher;
import uz.najottalim.springbootonetomnymanytomany.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    public List<PublisherResponseDto> fndAll() {
        return maptoDto(publisherRepository.findAll());
    }



    public Publisher findById(Long id) {
        Optional<Publisher> byId = publisherRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }else {
            throw new RuntimeException(String.format("Publisher  topilmadi") + id);

        }
    }


    public ResponseEntity<PublisherResponseDto> save(Publisher publisher) {
        PublisherResponseDto publisherResponseDto = mapToDto(publisherRepository.save(publisher));
        return ResponseEntity.ok(publisherResponseDto);
    }


    public ResponseEntity<PublisherResponseDto> delete(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            publisherRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Publisher mapToEntity(PublisherRequestDto dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getName());
        publisher.setBooks(dto.getBookId());
        publisher.setCity(dto.getCityId());
        publisher.setEmail(dto.getEmail());
        publisher.setOwner(dto.getOwner());
        return publisher;
    }



    private List<PublisherResponseDto> maptoDto(List<Publisher> categories) {
        return categories.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public PublisherResponseDto mapToDto(Publisher publisher) {
        PublisherResponseDto dto = new PublisherResponseDto();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        dto.setBookId(publisher.getBooks().get(0).getId());
        return dto;

    }
}
