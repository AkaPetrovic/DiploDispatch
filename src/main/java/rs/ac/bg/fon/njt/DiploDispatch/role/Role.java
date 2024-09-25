package rs.ac.bg.fon.njt.DiploDispatch.role;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DISPATCHER,
    MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
