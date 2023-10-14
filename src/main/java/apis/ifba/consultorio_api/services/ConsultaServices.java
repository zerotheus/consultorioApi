package apis.ifba.consultorio_api.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import apis.ifba.consultorio_api.adapter.ConsultaAdapter;
import apis.ifba.consultorio_api.interfaces.RegrasDeMarcacaoDeConsulta;
import apis.ifba.consultorio_api.model.Consulta;
import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.repository.ConsultaRepository;
import apis.ifba.consultorio_api.repository.MedicoRepository;
import apis.ifba.consultorio_api.repository.PacienteRepository;

@Service
public class ConsultaServices {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public ResponseEntity<Consulta> marcaConsulta(ConsultaForm consultaForm) {
        Consulta consulta = converteParaConsulta(consultaForm);
        estaDentroDasRegras(consultaForm);
        return ResponseEntity.created(null).body(consulta);
    }

    private Consulta converteParaConsulta(ConsultaForm consultaForm) {
        ConsultaAdapter consultaAdapter = new ConsultaAdapter(consultaForm);
        final Paciente paciente = encontraPaciente(consultaForm);
        encontraMedico(consultaForm);
        return consultaAdapter.converteConsulta(paciente, null);// TODO procurar medico e Paciente
    }

    private void estaDentroDasRegras(ConsultaForm consultaForm) {
        RegrasDeMarcacaoDeConsulta regras = new RegrasDeMarcacaoDeConsulta(consultaForm);
        try {
            regras.validar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.toString());
        }
    }

    private Paciente encontraPaciente(ConsultaForm consultaForm) {
        final Optional<Paciente> paciente = pacienteEstaCadastrado(consultaForm);
        if (paciente.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "O paciente deve ser informado");
        }
        return paciente.get();
    }

    private Medico encontraMedico(ConsultaForm consultaForm) {
        if (consultaForm.getMedicoId() == null) {
            System.out.println(medicoRepository.findAllAvaliable());
        }
        return null;
    }

    private Optional<Paciente> pacienteEstaCadastrado(ConsultaForm consultaForm) {
        return pacienteRepository.findByIdAndStatus(consultaForm.getPacienteId(), true);
    }

    private Optional<Medico> medicoEstaCadastrado(ConsultaForm consultaForm) {
        return medicoRepository.findByIdAndStatus(consultaForm.getMedicoId(), true);
    }

}
