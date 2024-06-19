package crud.oht.service.JPAentity;

import crud.oht.service.DTOs.DTOrelatorio;
import crud.oht.service.DTOs.UpMulta;
import crud.oht.service.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatorio")
@Entity(name = "Relatorio")
@EqualsAndHashCode(of = "RU")

public class Entity_Relatorio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String RU;

    private String CPF;

    private String titulo;

    private String relatorio;

    @Enumerated(EnumType.STRING)
    private Status status;


    public Entity_Relatorio(DTOrelatorio json) {

        this.CPF = json.CPF();
        this.titulo = json.titulo();
        this.relatorio = json.relatorio();
        this.status = Status.ABERTO;
    }
}
