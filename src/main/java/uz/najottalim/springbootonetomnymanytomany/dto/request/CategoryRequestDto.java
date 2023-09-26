package uz.najottalim.springbootonetomnymanytomany.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CategoryRequestDto {

    private String name;
    private Long bookId;
}
