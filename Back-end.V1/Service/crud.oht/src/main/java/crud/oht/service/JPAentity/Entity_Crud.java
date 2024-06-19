package crud.oht.service.JPAentity;

import crud.oht.cepServicy.DTOs.DTOcep;
import crud.oht.service.DTOs.FieldDTO.formCreated;
import crud.oht.service.Enum.Situacao;
import crud.oht.service.Enum.causa;
import crud.oht.userPropeties.DTOs.UpUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "informacoes_cidadao")
@Entity(name = "Informacoes_cidadao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "RU")
public class Entity_Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String RU;

    @Enumerated(EnumType.STRING)
    private causa ocorrido;

    private String agente;

    private String dataa;

    private String valor;

    @Embedded
    private Entity_Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private String CPF;

    private Boolean ativo;


    public Entity_Crud(formCreated created, DTOcep endereco) {
        this.ocorrido = created.ocorrido();
        this.agente = created.agente();
        this.dataa = created.data();
        this.valor = created.valor();
        this.situacao = created.situacao();
        this.CPF = created.CPF();
        this.ativo = true;

        this.endereco = new Entity_Endereco(endereco);
    }

    public void updateUser(UpUser jsonn) {
        this.endereco.updateUser(jsonn.endereco());
    }

    public void deleteLO() {
        this.ativo = false;
    }


}
