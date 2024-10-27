package rs.ac.bg.fon.njt.DiploDispatch.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.njt.DiploDispatch.dto.PasswordChangeDTO;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Boolean checkIfExistsByUsername(String username) {
        if(userRepository.findByUsername(username).isEmpty()){
            throw new NoSuchElementException("User with the given username does not exist");
        }
        return true;
    }

    public void resetPassword(PasswordChangeDTO passwordChangeDTO) {
        String username = passwordChangeDTO.getUsername();
        String newPassword = passwordChangeDTO.getNewPassword();

        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new NoSuchElementException("User with the given username does not exist");
        }
        User user = userOptional.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
