package rs.ac.bg.fon.njt.DiploDispatch.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rs.ac.bg.fon.njt.DiploDispatch.user.User;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}