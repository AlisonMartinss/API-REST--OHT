package crud.oht.service.Repository;

import crud.oht.service.JPAentity.Entity_Crud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryCrud extends JpaRepository<Entity_Crud,String> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM informacoes_cidadao WHERE ATIVO = TRUE AND CPF = :CPF")
    List<Entity_Crud>findByCPF(@Param("CPF") String cpf);

    @Query(nativeQuery = true,
            value = "SELECT * FROM informacoes_cidadao WHERE ATIVO = TRUE AND CPF = :CPF AND SITUACAO = :SITU" )
    List<Entity_Crud>findBySituacao(@Param("CPF") String cpf, @Param("SITU") String situacao);



    List findByRU(String RU);
}
