package crud.oht.service.JPAentity;

import crud.oht.cepServicy.DTOs.DTOcep;
import crud.oht.service.DTOs.endereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Entity_Endereco {

    private String CEP;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String UF;

    public Entity_Endereco(DTOcep endereco) {

        this.CEP = endereco.cep();

        this.logradouro = endereco.logradouro();

        this.complemento = endereco.complemento();

        this.bairro = endereco.bairro();

        this.UF = endereco.uf();
    }


    public void updateUser(endereco endereco) {

        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if (endereco.CEP() != null){
            this.CEP = endereco.CEP();
        }

        if (endereco.UF() != null){
            this.UF = endereco.UF();
        }
        if (endereco.Complemento() != null){
            this.complemento = endereco.Complemento();
        }
    }

}
