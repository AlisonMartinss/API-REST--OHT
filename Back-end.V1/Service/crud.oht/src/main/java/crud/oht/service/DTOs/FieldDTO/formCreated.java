package crud.oht.service.DTOs.FieldDTO;

import crud.oht.service.DTOs.endereco;
import crud.oht.service.Enum.Situacao;
import crud.oht.service.Enum.causa;

public record formCreated(causa ocorrido, String agente, String data, String valor, Situacao situacao, String CPF,String CEP) {
}
