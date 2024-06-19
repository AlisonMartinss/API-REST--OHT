package crud.oht.Controler;

import crud.oht.cepServicy.cepServicy;
import crud.oht.userPropeties.DTOs.DTOtokenn;
import crud.oht.userPropeties.DTOs.userForm;
import crud.oht.userPropeties.DTOs.userFormLogin;
import crud.oht.userPropeties.JPAentity.Entity_user;
import crud.oht.userPropeties.Repositorys.Repository_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import crud.oht.Configurations.TokenService.toekService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/login")
public class ControlerLogin {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private toekService toekService;
    @Autowired
    private Repository_user repositoryUser;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private cepServicy cepServicy;

    @PostMapping
    @Transactional
    public ResponseEntity login (@RequestBody userFormLogin user){


        var DTOtoken = new UsernamePasswordAuthenticationToken(user.CPF(),user.senha());
        var loginREF = manager.authenticate(DTOtoken);
        var tokenOK = toekService.TokenGeneration((Entity_user) loginREF.getPrincipal());



        return ResponseEntity.ok(new DTOtokenn(tokenOK));
    }


    @PostMapping("/CreateUser")
    @Transactional
    public ResponseEntity cadastro (@RequestBody userForm userForm){

        var endereco = cepServicy.searchCEP(userForm.CEP());

        /* CRIANDO HASHING DE SENHA */
        var crip = passwordEncoder.encode(userForm.senha());



        /* CRIANDO OBJETO E SALVANDO USER */
        repositoryUser.save(new Entity_user(userForm,crip,endereco));


        return ResponseEntity.ok().build();


    }



}
