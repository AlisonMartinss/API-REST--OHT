package crud.oht.authoreties;

public class AdminRole implements org.springframework.security.core.GrantedAuthority {
    @Override
    public String getAuthority() {
        return "O_CABA";
    }
}
