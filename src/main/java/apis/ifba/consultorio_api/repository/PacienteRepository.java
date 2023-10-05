package apis.ifba.consultorio_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.model.Pessoa;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByPessoa(Pessoa pessoa);

    Optional<Paciente> findByIdAndStatus(Long id, Boolean status);

    List<Paciente> findByStatus(Boolean status);
}
