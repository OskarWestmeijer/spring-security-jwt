package westmeijer.oskar.springsecurityjwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import westmeijer.oskar.springsecurityjwt.entity.Country;

import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Country>> formLoginBased(Principal principal) {
        log.info("FormLogin route for principal: {}", principal);
        return getCountries();
    }

    @GetMapping("/api/basic-auth/countries")
    public ResponseEntity<Iterable<Country>> basicAuth(Principal principal) {
        log.info("BasicAuth route for principal: {}", principal);
        return getCountries();

    }

    @GetMapping("/api/unsecured/countries")
    public ResponseEntity<Iterable<Country>> unsecured(Principal principal) {
        log.info("Unsecured route for principal: {}", principal);
        return getCountries();
    }

    private ResponseEntity<Iterable<Country>> getCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        log.info("Retrieving countries: {}", countries);
        return ResponseEntity.ok(countries);
    }


}
