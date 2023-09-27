package apis.ifba.consultorio_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apis.ifba.consultorio_api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
