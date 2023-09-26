package uz.najottalim.springbootonetomnymanytomany.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.springbootonetomnymanytomany.dto.request.CityRequestDto;
import uz.najottalim.springbootonetomnymanytomany.dto.response.CityResponseDto;
import uz.najottalim.springbootonetomnymanytomany.model.City;
import uz.najottalim.springbootonetomnymanytomany.model.Country;
import uz.najottalim.springbootonetomnymanytomany.repository.CityRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private final CountryService countryService;

    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public List<CityResponseDto> fndAll() {
        return maptoDto(cityRepository.findAll());
    }




    public CityResponseDto findById(Long id) {
        Optional<City> cityOptional= cityRepository.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            CityResponseDto dto = mapToDto1(city);
            return dto;
        } else {
            return null;

        }
    }

    public ResponseEntity<CityResponseDto> delete(Long id) {
        Optional<City> optionalBook = cityRepository.findById(id);
        if (optionalBook.isPresent()) {
            cityRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public CityResponseDto save(CityRequestDto cityRequestDto) {
        City city = mapToEntity(cityRequestDto);
        Country byId = countryService.findById(cityRequestDto.getCountryId());
        city.setCountry(byId);
        cityRepository.save(city);
        countryService.save(byId);
        CityResponseDto responseDto = mapToDto(city);
        return responseDto;

    }

    public City mapToEntity(CityRequestDto dto) {
        City city = new City();
        city.setName(dto.getName());
        return city;
    }


    public CityResponseDto mapToDto1(City city) {
        CityResponseDto dto = new CityResponseDto();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setCountryId(city.getCountry().getId());
        return dto;
    }

    private List<CityResponseDto> maptoDto(List<City> cities) {
        return cities.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    public CityResponseDto mapToDto(City city) {
        CityResponseDto dto = new CityResponseDto();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setCountryId(city.getCountry().getId());
        return dto;

    }
}
