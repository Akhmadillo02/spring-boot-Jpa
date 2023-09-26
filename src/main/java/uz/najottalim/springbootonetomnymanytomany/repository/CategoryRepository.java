package uz.najottalim.springbootonetomnymanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.springbootonetomnymanytomany.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
