package crud.oht.cepServicy;
import crud.oht.cepServicy.DTOs.DTOcep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


@Service
public class cepServicy {


 public DTOcep searchCEP (String CEP) {
     RestTemplate restTemplate = new RestTemplate();
     ResponseEntity<DTOcep> resultado = restTemplate.
                     getForEntity(String.format
                     ("https://viacep.com.br/ws/%s/json/",CEP), DTOcep.class);

     return resultado.getBody();

 }
}

