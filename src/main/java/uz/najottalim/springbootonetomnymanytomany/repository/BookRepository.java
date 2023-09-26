package uz.najottalim.springbootonetomnymanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.springbootonetomnymanytomany.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
