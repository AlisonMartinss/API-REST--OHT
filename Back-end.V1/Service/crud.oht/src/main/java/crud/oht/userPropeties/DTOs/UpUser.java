package crud.oht.userPropeties.DTOs;

import crud.oht.service.DTOs.endereco;


public record UpUser(String CPF, endereco endereco,String senha) {
}
