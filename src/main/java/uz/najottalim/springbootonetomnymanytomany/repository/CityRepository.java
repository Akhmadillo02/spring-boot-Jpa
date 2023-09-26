package uz.najottalim.springbootonetomnymanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.springbootonetomnymanytomany.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
