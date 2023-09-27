package apis.ifba.consultorio_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import apis.ifba.consultorio_api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value = "select * from pessoas where email = ?1")
    Pessoa findByEmail(@Param("email") String email);

}
