package crud.oht.Configurations;

import crud.oht.authoreties.AdminRole;
import crud.oht.userPropeties.JPAentity.Entity_user;
import crud.oht.userPropeties.Repositorys.Repository_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class logicLogin implements UserDetailsService {

    /* Essa é a classe repository, que é chamada de forma indireta quando vamos fazer o Lgin */

    @Autowired
    private Repository_user repositoryUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUser.getReferenceById(username);}
    }

