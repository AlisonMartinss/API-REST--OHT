package crud.oht.service.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpMulta(String RU, endereco endereco, String CPF) {
}
