package apis.ifba.consultorio_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.adapter.PacienteAdapter;
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
        final PacienteAdapter pacienteAdapter = new PacienteAdapter(pacienteForm);
        Paciente paciente = pacienteAdapter.convertePacienteForm();
        if (jaPossuiAlgumCadastroNoSistema(paciente)) {
            cadastroJaEstaRelacionadoAoutroPaciente(paciente.getPessoa());
            return ResponseEntity.badRequest().build();
        }
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
        final PacienteAdapter pacienteAdapter = new PacienteAdapter(pacienteFormComEdicoes);
        final Paciente pacienteComEdicoes = pacienteAdapter.convertePacienteForm();
        pessoaServices.editaPessoa(pacienteAserEditado.get().getId(), pacienteComEdicoes.getPessoa());
        return null;
    }

}
