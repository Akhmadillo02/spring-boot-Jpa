package uz.najottalim.springbootonetomnymanytomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String owner;

    private String email;


    @ManyToOne
    private City city;


    @OneToMany(mappedBy = "publisher")
    private List<Book>books;


    public void setBooks(Long bookId) {
        this.books.get(0);
    }

    public void setCity(Long cityId) {
        this.city.getId();
    }
}
