package westmeijer.oskar.springsecurityjwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import westmeijer.oskar.springsecurityjwt.entity.Country;

@RestController
@Slf4j
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/api/basic-auth/countries")
    public ResponseEntity<Iterable<Country>> ping() {
        return getCountries();

    }

    @GetMapping("/api/web-login/countries")
    public ResponseEntity<Iterable<Country>> secrets() {
        return getCountries();
    }

    @GetMapping("/api/unsecured/countries")
    public ResponseEntity<Iterable<Country>> countries() {
        return getCountries();
    }

    private ResponseEntity<Iterable<Country>> getCountries(){
        Iterable<Country> countries = countryRepository.findAll();
        log.info("Countries: {}", countries);
        return ResponseEntity.ok(countries);
    }


}
