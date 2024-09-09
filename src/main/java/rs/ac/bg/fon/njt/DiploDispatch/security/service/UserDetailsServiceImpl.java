package rs.ac.bg.fon.njt.DiploDispatch.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.security.model.UserDetailsImpl;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;
import rs.ac.bg.fon.njt.DiploDispatch.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return new UserDetailsImpl(optionalUser.get());
        }
        throw new IllegalArgumentException("User not found with the given username");
    }
}
