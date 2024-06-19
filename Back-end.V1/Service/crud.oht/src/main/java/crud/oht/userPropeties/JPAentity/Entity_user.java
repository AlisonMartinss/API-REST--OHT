package crud.oht.userPropeties.JPAentity;

import crud.oht.cepServicy.DTOs.DTOcep;
import crud.oht.service.DTOs.endereco;
import crud.oht.service.JPAentity.Entity_Endereco;
import crud.oht.userPropeties.DTOs.UpUser;
import crud.oht.userPropeties.DTOs.userForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "user_table")
@Entity(name = "user_table")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "CPF")
public class Entity_user implements UserDetails {

    @Id
    private String CPF;

    private String senha;

    @Enumerated
    private Entity_Endereco endereco;


    public Entity_user(userForm userForm, String crip, DTOcep endereco ) {
        this.CPF = userForm.CPF();
        this.senha = crip;
        this.endereco = new Entity_Endereco(endereco);

    }


    public void putUser(crud.oht.service.DTOs.endereco endereco) {
        this.endereco.updateUser(endereco);
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return CPF;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
