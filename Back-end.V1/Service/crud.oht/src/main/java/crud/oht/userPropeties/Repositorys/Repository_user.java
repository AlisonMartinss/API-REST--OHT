package crud.oht.userPropeties.Repositorys;

import crud.oht.userPropeties.JPAentity.Entity_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface Repository_user extends JpaRepository<Entity_user,String> {
    UserDetails findByCPF(String username);

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_table WHERE ATIVO = TRUE AND CPF = :CPF")
    List<Entity_user> procuraOCP(@Param("CPF") String OCP);
}
