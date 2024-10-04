package rs.ac.bg.fon.njt.DiploDispatch.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authenticationService.login(user);
    }
}
