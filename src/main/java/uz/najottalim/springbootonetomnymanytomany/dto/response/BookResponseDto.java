package uz.najottalim.springbootonetomnymanytomany.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookResponseDto {

    private Long id;

    private String name;

    private String publisherDate;

    private Double price;

    private Long cityId;

    private Long authorId;

    private Long tagId;

    private Long categoryId;
}
