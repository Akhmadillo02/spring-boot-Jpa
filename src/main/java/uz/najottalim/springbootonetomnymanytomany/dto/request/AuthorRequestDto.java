package uz.najottalim.springbootonetomnymanytomany.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthorRequestDto {

    private Long cityId;

    private String firstName;

    private String lastName;

    private String email;
}
