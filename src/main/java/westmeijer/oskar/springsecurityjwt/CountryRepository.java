package westmeijer.oskar.springsecurityjwt;

import org.springframework.data.repository.CrudRepository;
import westmeijer.oskar.springsecurityjwt.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
