package apis.ifba.consultorio_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.adapter.PacienteAdapter;
import apis.ifba.consultorio_api.interfaces.RegrasEspecificasDePaciente;
import apis.ifba.consultorio_api.interfaces.RegrasPaciente;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.model.Pessoa;
import apis.ifba.consultorio_api.repository.PacienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;
    private PessoaServices pessoaServices;

    public ResponseEntity<Paciente> cadastraPaciente(PacienteForm pacienteForm) {
        Paciente paciente = adaptaFormularioDePaciente(pacienteForm);
        paciente.setStatus(true);
        if (jaPossuiAlgumCadastroNoSistema(paciente)) {
            cadastroJaEstaRelacionadoAoutroPaciente(paciente.getPessoa());
            return ResponseEntity.badRequest().build();
        }
        pessoaServices.cadastraPessoa(paciente.getPessoa());
        return ResponseEntity.created(null).body(pacienteRepository.save(paciente));
    }

    private boolean jaPossuiAlgumCadastroNoSistema(Paciente paciente) {
        Optional<Pessoa> pessoaExistente = pessoaServices.pessoaJaCadastrada(paciente.getPessoa());
        if (pessoaExistente.isPresent()) {
            paciente.setPessoa(pessoaExistente.get());
            return true;
        }
        return false;
    }

    private boolean cadastroJaEstaRelacionadoAoutroPaciente(Pessoa pessoa) {
        return pacienteRepository.findByPessoa(pessoa).isPresent();
    }

    public ResponseEntity<Paciente> editaPaciente(Long id, PacienteForm pacienteFormComEdicoes) {
        Optional<Paciente> pacienteAserEditado = pacienteRepository.findById(id);
        if (pacienteAserEditado.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        try {
            validaEdicoes(pacienteAserEditado.get(), pacienteFormComEdicoes);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.toString());
        }
        final Paciente pacienteComEdicoes = adaptaFormularioDePaciente(pacienteFormComEdicoes);
        // bad smell
        final Pessoa pessoaComEdicoes = pessoaServices.editaPessoa(pacienteAserEditado.get().getPessoa().getId(),
                pacienteComEdicoes.getPessoa());
        // Pq as pessoas gostam disso abaixo?
        return pacienteAserEditado.map(pacienteEmEdicao -> {
            pacienteEmEdicao.setCpf(pacienteComEdicoes.getCpf());
            pacienteEmEdicao.setPessoa(pessoaComEdicoes);
            pacienteRepository.save(pacienteEmEdicao);
            System.out.println(pacienteComEdicoes);
            return ResponseEntity.created(null).body(pacienteEmEdicao);
        }).orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<Paciente> encontraPacientePeloId(Long id) {
        return pacienteRepository.findById(id).map(pacienteEncontrado -> {
            return ResponseEntity.ok().body(pacienteEncontrado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Setar como inativo ainda, ainda falta o atributo
    public ResponseEntity<Object> apagaPaciente(Long id) {
        Optional<Paciente> pacienteAserExcluido = pacienteRepository.findByIdAndStatus(id, true);
        if (pacienteAserExcluido.isEmpty()) {
            return ResponseEntity.notFound().build();
        } // Pq as pessoas gostam disso abaixo?
        return pacienteAserExcluido.map(pacienteEmExclusao -> {
            pacienteEmExclusao.setStatus(false);
            pacienteRepository.save(pacienteEmExclusao);
            System.out.println(pacienteEmExclusao);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.badRequest().build());
    }

    public void validaEdicoes(Paciente paciente, PacienteForm pacienteForm) throws Exception {
        final RegrasEspecificasDePaciente regras = new RegrasPaciente(paciente, pacienteForm);
        regras.validar();
    }

    public Paciente adaptaFormularioDePaciente(PacienteForm pacienteForm) {
        final PacienteAdapter pacienteAdapter = new PacienteAdapter(pacienteForm);
        return pacienteAdapter.convertePacienteForm();
    }

    public Page<Paciente> listaPacientes(Pageable pageable) {
        System.out.println(pacienteRepository.findAll(pageable).getNumberOfElements());
        return pacienteRepository.findAll(pageable);
    }

}
