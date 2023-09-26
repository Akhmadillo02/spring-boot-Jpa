package uz.najottalim.springbootonetomnymanytomany.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PublisherRequestDto {

    private String name;
    private String owner;

    private String email;

    private Long cityId;

    private Long bookId;


}
