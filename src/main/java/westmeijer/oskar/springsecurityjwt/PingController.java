package westmeijer.oskar.springsecurityjwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/api/v1/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");

    }

    @GetMapping("/api/v1/secrets")
    public ResponseEntity<String> secrets() {
        return ResponseEntity.ok("I like to code.");

    }


}
