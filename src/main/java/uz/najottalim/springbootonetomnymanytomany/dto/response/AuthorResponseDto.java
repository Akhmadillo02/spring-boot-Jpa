package uz.najottalim.springbootonetomnymanytomany.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthorResponseDto {
    private Long id;
    private Long cityId;

    private String firstName;

    private String lastName;

    private String email;
}
