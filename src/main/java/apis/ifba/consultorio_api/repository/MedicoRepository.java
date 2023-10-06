package apis.ifba.consultorio_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.model.Pessoa;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByPessoa(Pessoa pessoa);

    Optional<Medico> findByIdAndStatus(Long id, Boolean status);

    List<Medico> findAllByStatus(Boolean status, Pageable pageable);

}
