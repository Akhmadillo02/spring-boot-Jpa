package uz.najottalim.springbootonetomnymanytomany.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.najottalim.springbootonetomnymanytomany.model.Book;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PublisherResponseDto {

    private Long id;
    private String name;
    private String owner;

    private String email;

    private Long cityId;

    private Long bookId;


}
