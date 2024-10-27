package rs.ac.bg.fon.njt.DiploDispatch.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.njt.DiploDispatch.dto.PasswordChangeDTO;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/check-if-exists-by-username")
    public Boolean checkIfExistsByUsername(@RequestParam(required = false) String username) {
        return userService.checkIfExistsByUsername(username);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordChangeDTO passwordChangeDTO) {
        userService.resetPassword(passwordChangeDTO);
        return new ResponseEntity<>("Success: Password has been changed successfully.", HttpStatus.OK);
    }
}
