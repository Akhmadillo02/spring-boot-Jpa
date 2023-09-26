package uz.najottalim.springbootonetomnymanytomany.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CityRequestDto {

    private Long countryId;
    private String name;
}
