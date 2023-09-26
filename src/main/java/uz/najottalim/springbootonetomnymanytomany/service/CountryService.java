package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CountryRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CountryResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.Country;
import uz.najottalim.springbootonetomnymanytomany.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponseDto> fndAll() {
        return maptoDto(countryRepository.findAll());
    }



    public Country findById(Long id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            CountryResponseDto dto = mapToDto(country);
            return country;
        } else {
            return null;

        }
    }


    public ResponseEntity<CountryResponseDto> save(Country country) {
        CountryResponseDto countryResponseDto = mapToDto(countryRepository.save(country));
        return ResponseEntity.ok(countryResponseDto);
    }


    public ResponseEntity<CountryResponseDto> delete(Long id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        if (countryOptional.isPresent()) {
            countryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Country mapToEntity(CountryRequestDto dto) {
        Country city = new Country();
        city.setName(dto.getName());
        return city;
    }



    private List<CountryResponseDto> maptoDto(List<Country> countries) {
        return countries.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public CountryResponseDto mapToDto(Country country) {
        CountryResponseDto dto = new CountryResponseDto();
        dto.setId(country.getId());
        dto.setName(country.getName());
        return dto;

    }
}
