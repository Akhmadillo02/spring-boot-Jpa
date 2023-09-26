package uz.najottalim.springbootonetomnymanytomany.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryResponseDto {


    private Long id;
    private String name;
}
