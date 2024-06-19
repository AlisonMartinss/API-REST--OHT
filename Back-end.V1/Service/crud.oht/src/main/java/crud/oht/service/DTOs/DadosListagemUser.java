package crud.oht.service.DTOs;

import crud.oht.cepServicy.DTOs.DTOcep;
import crud.oht.service.JPAentity.Entity_Endereco;
import crud.oht.userPropeties.JPAentity.Entity_user;

public record DadosListagemUser(String cpf, String logradouro,String complemento,String bairro,String uf,String cep) {

    public DadosListagemUser (Entity_user user) {
        this(user.getCPF(),
                user.getEndereco().getLogradouro(),
                user.getEndereco().getComplemento(),
                user.getEndereco().getBairro(),
                user.getEndereco().getUF(),
                user.getEndereco().getCEP());
    }
}
