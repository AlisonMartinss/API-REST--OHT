package crud.oht.service.DTOs;

import crud.oht.service.Enum.Situacao;
import crud.oht.service.Enum.causa;

public record creatingform(causa ocorrido, String agente, String data, String valor, endereco endereco, Situacao situacao, String CPF) {
}

