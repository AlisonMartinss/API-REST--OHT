package crud.oht.userPropeties.service;


import crud.oht.userPropeties.DTOs.userForm;
import crud.oht.userPropeties.JPAentity.Entity_user;
import crud.oht.userPropeties.Repositorys.Repository_user;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class userService {


    @Autowired
    private Repository_user repositoryUser;

    /*@Transactional
    public void creatingAccount(@RequestBody userForm JSON) {
        var user = new Entity_user(JSON);
        repositoryUser.save(user);
    }
    */



}
