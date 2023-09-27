package apis.ifba.consultorio_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apis.ifba.consultorio_api.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
