package uz.najottalim.springbootonetomnymanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najottalim.springbootonetomnymanytomany.model.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {




}
