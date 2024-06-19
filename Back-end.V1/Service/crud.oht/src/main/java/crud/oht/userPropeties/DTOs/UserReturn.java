package crud.oht.userPropeties.DTOs;

import crud.oht.service.JPAentity.Entity_Endereco;
import crud.oht.userPropeties.JPAentity.Entity_user;
import org.apache.catalina.User;

public record UserReturn(String CEP, String LOGRADOURO, String BAIRRO, String UF) {


    public UserReturn(Entity_user entityUser) {
        this(   entityUser.getEndereco().getCEP(),
                entityUser.getEndereco().getLogradouro(),
                entityUser.getEndereco().getBairro(),
                entityUser.getEndereco().getUF());
    }
}
