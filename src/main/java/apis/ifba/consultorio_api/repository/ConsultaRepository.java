package apis.ifba.consultorio_api.repository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import apis.ifba.consultorio_api.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(nativeQuery = true, value = "Select * from consultas where horario > current_date and fk_paciente_id = ?1")
    public List<Consulta> jaPossuiConsultaAgendada(@Param(value = "id") Long id);// TODO mudar para a data e hora da
    // consulta

    // @Query(nativeQuery = true, value = "select * from (values :ids) as medicos")
    @Query(nativeQuery = true, value = "SELECT fk_medico_id FROM consultas WHERE horario > :horaMarcada AND estado != 'Cancelada' and fk_medico_id is not null")
    public List<Long> medicosDisponiveis(@Param("horaMarcada") LocalDateTime horaMarcada);
    // TODO retirar not null e Renomear query
}
