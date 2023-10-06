package apis.ifba.consultorio_api.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apis.ifba.consultorio_api.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(nativeQuery = true, name = "a")
    public Consulta consultaExistsToday(LocalDateTime localDateTime);

}
