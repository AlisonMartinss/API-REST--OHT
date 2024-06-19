package crud.oht.Controler;

import crud.oht.service.DTOs.DTOrelatorio;
import crud.oht.service.DTOs.DadosListagemUser;
import crud.oht.service.DTOs.FieldDTO.formCreated;
import crud.oht.service.DTOs.UpMulta;
import crud.oht.service.JPAentity.Entity_Crud;
import crud.oht.userPropeties.DTOs.UpUser;
import crud.oht.userPropeties.DTOs.UserReturn;
import crud.oht.userPropeties.JPAentity.Entity_user;
import crud.oht.userPropeties.Repositorys.Repository_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import crud.oht.service.crudService;
import crud.oht.cepServicy.cepServicy;

import java.util.List;

@RestController
@RequestMapping("/principal")
public class ControlerCrud {

    @Autowired
    private crudService crudService;

    @Autowired
    private Repository_user entity_user;
    @Autowired
    private cepServicy cepServicy;

    @PostMapping
    public void creating (@RequestBody formCreated created){

        var endereco = cepServicy.searchCEP(created.CEP());

        crudService.creating(created, endereco);
    }

    @PostMapping("/Read/{npage}/{nperpage}/{option}")
    public ResponseEntity<List<Entity_Crud>> realese (@RequestBody UpMulta JSON,@PathVariable int npage,@PathVariable int nperpage,@PathVariable int option){

        var resultado = crudService.realiseAll(JSON,npage,nperpage,option);
        return resultado;
    }

    @PostMapping("/atualizar")
    public List<UserReturn> UpdateUser (@RequestBody UpUser JSON){
        var userUP = crudService.updateUser(JSON);
        var search = entity_user.procuraOCP(JSON.CPF());
        var retorno = search.stream().map(UserReturn::new).toList();

        return retorno;

    }

    @PutMapping
    public ResponseEntity delete (@RequestBody UpMulta JSON){
        crudService.delete(JSON);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Busca")
    public ResponseEntity<List<Entity_Crud>> MostraMulta (@RequestBody UpMulta JSON){
        var Multa = crudService.ShowFine(JSON);
        return ResponseEntity.ok(Multa);
    }

    @PostMapping("/User")
    public ResponseEntity<List<DadosListagemUser>> User (@RequestBody UpMulta JSON){
        var User = crudService.User(JSON);
        return ResponseEntity.ok(User);
    }

    @PostMapping("/Relatorio")
    public ResponseEntity  Relatorio (@RequestBody DTOrelatorio orelatorio){
        crudService.Relatorio(orelatorio);

        return ResponseEntity.ok().build();
    }

}