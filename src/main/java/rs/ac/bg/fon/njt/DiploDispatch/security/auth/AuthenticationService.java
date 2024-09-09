package rs.ac.bg.fon.njt.DiploDispatch.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.security.service.JWTService;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();

            String username = principal.getUsername();
            GrantedAuthority[] authorities = principal.getAuthorities().toArray(new GrantedAuthority[0]);
            String authority = authorities[0].getAuthority();

            return jwtService.generateToken(username, authority);
        }

        throw new IllegalArgumentException("Invalid username or password");
    }
}
