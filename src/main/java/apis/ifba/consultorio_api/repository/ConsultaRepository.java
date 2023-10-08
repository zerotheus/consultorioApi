package apis.ifba.consultorio_api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import apis.ifba.consultorio_api.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(nativeQuery = true, value = "Select * from consultas where horario > current_date and fk_paciente_id = ?1")
    public List<Consulta> jaPossuiConsultaAgendada(@Param(value = "id") Long id);

}
