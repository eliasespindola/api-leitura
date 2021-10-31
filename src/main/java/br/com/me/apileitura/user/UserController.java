package br.com.me.apileitura.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import static org.springframework.http.ResponseEntity.created;


@RestController
@AllArgsConstructor
class UserController {

    private final UserRepository userRepository;

    @PostMapping(value = "/api/users")
    public ResponseEntity<Long> createUser(@RequestBody @Valid NewUserRequestForm newUserRequestForm){
        User user = userRepository.save(newUserRequestForm.toModel());
        URI location = URI.create("/api/users/" + user.getId());
        return created(location).build();
    }

}
