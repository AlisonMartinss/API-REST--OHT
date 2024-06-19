package crud.oht.service;

import crud.oht.cepServicy.DTOs.DTOcep;
import crud.oht.service.DTOs.DTOrelatorio;
import crud.oht.service.DTOs.DadosListagemUser;
import crud.oht.service.DTOs.FieldDTO.formCreated;
import crud.oht.service.DTOs.UpMulta;
import crud.oht.service.DTOs.pageReference;
import crud.oht.service.JPAentity.Entity_Crud;
import crud.oht.service.JPAentity.Entity_Relatorio;
import crud.oht.service.Repository.RepositoryCrud;
import crud.oht.service.Repository.RepositoryRelatorio;
import crud.oht.userPropeties.DTOs.UpUser;
import crud.oht.userPropeties.JPAentity.Entity_user;
import crud.oht.userPropeties.Repositorys.Repository_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class crudService {

    @Autowired
    private RepositoryCrud repositoryCrud;
    @Autowired
    private Repository_user repository_user;

    @Autowired
    private RepositoryRelatorio relatorio;

    @Autowired
    private paginationService pagination;




    @Transactional
    public void creating(formCreated created, DTOcep endereco) {
        var User = new Entity_Crud(created, endereco);
        repositoryCrud.save(User);
    }

    @Transactional
    public ResponseEntity<List<Entity_Crud>> realiseAll (@RequestBody UpMulta upMulta,int nPage, int nperpage, int option){

        /** Operação responsavel por Buscar Lista e Definir Criterio (49 - 65) **/

         var listaMultas = repositoryCrud.findByCPF(upMulta.CPF());

         if ( option == 1){
             listaMultas.sort(Comparator.comparing(Entity_Crud::getValor).reversed());
         }

        if ( option == 2){
            listaMultas.sort(Comparator.comparing(Entity_Crud::getDataa).reversed());
        }

        if ( option == 3){

            listaMultas = repositoryCrud.findBySituacao(upMulta.CPF(),"PENDENDE");
        }

        if ( option == 4){
            listaMultas = repositoryCrud.findBySituacao(upMulta.CPF(),"PAGO");
        }


        /** Operação responsavel por fazer Paginação (54) **/

        var resultado  = pagination.pagination(listaMultas,nPage,nperpage);

         /** As tres linhas de código a seguir trata-se da definiçõa do numero de paginas do 'Read' (58-65). **/

         double nResto = 0;
         int nPaginas = (listaMultas.size()) / nperpage;

         if ( ((listaMultas.size()) % nperpage) != 0){
             nResto = 1;
         }

         int npag = nPaginas + (int)nResto;


        /** Criação Do cabeçalho, onde vai o n pagina **/

        var head = new HttpHeaders();

        head.add("Numero-de-Paginas",String.valueOf(npag));


        return new ResponseEntity<>(resultado,head, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity updateUser(@RequestBody UpUser JSON) {
        var entityUser = repository_user.getReferenceById(JSON.CPF());
        entityUser.putUser(JSON.endereco());

        return ResponseEntity.ok().build();
    }
    @Transactional
    public void delete (@RequestBody UpMulta JSON){
        var retorno = repositoryCrud.getReferenceById(JSON.RU());
        retorno.deleteLO();

    }

    // QUAL A DIFERENÇA DO RETORNO DO METODO 'getReferenceByX' e 'findByX'

    @Transactional
    public List<Entity_Crud> ShowFine (@RequestBody UpMulta JSON){
        var retorno = repositoryCrud.findByRU(JSON.RU());

        return retorno;

    }

    @Transactional
    public List<DadosListagemUser> User (@RequestBody UpMulta JSON){
        var retorno = repository_user.procuraOCP(JSON.CPF()).stream().map(DadosListagemUser::new).toList();

        return retorno;

    }

    @Transactional
    public ResponseEntity Relatorio (@RequestBody DTOrelatorio JSON){
        var User = new Entity_Relatorio(JSON);
        var retorno = relatorio.save(User);

        return ResponseEntity.ok().build();

    }

}
