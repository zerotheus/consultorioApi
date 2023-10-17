package apis.ifba.consultorio_api.services;

import java.util.List;
import java.util.Random;
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

@Service
public class ConsultaServices {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteServices pacienteServices;
    @Autowired
    private MedicoServices medicoServices;

    public ResponseEntity<Consulta> marcaConsulta(ConsultaForm consultaForm) {
        Consulta consulta = converteParaConsulta(consultaForm);
        estaDentroDasRegras(consultaForm);
        // consultaRepository.save(consulta);
        return ResponseEntity.created(null).body(consulta);
    }

    private Consulta converteParaConsulta(ConsultaForm consultaForm) {
        ConsultaAdapter consultaAdapter = new ConsultaAdapter(consultaForm);
        final Paciente paciente = encontraPaciente(consultaForm);
        final Medico medico = encontraMedico(consultaForm);
        return consultaAdapter.converteConsulta(paciente, medico);
    }

    private void estaDentroDasRegras(ConsultaForm consultaForm) {
        RegrasDeMarcacaoDeConsulta regras = new RegrasDeMarcacaoDeConsulta(consultaForm);
        try {
            regras.validar();
            if (!consultaRepository
                    .jaPossuiConsultaAgendada(consultaForm.getPacienteId(), consultaForm.getDataHorario().withHour(0))
                    .isEmpty()) {
                throw new Exception("So e permitido o agendamento de 1 consulta por dia");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.toString());
        }
    }

    private Paciente encontraPaciente(ConsultaForm consultaForm) {
        final Paciente paciente = pacienteEstaCadastrado(consultaForm);
        return paciente;
    }

    private Medico encontraMedico(ConsultaForm consultaForm) {
        Medico medico = null;
        if (consultaForm.getMedicoId() == null) {
            List<Long> medicosIds = medicoServices.listaTodosMedicosDisponiveis();
            List<Long> medicosIndi = consultaRepository.medicosIndisponiveis(consultaForm.getDataHorario(),
                    consultaForm.getDataHorario().plusHours(1));
            medicosIds.removeAll(medicosIndi);
            medico = medicoServices.encontraMedico(escolheUmMedicoAleatorio(medicosIds));
        } else {
            medico = medicoEstaCadastrado(consultaForm);
            verificaDisponibilidadeDoMedico(medico.getId(), consultaForm);
        }
        return medico;
    }

    private Paciente pacienteEstaCadastrado(ConsultaForm consultaForm) {
        return pacienteServices.encontraPaciente(consultaForm.getPacienteId());
    }

    private Medico medicoEstaCadastrado(ConsultaForm consultaForm) {
        return medicoServices.encontraMedico(consultaForm.getMedicoId());
    }

    private Long escolheUmMedicoAleatorio(List<Long> medicosList) {
        if (medicosList.size() == 0) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Medicos indisponiveis neste horario");
        }
        final Random random = new Random();
        return medicosList.get(random.nextInt(0, medicosList.size()));
    }

    private void verificaDisponibilidadeDoMedico(Long id, ConsultaForm consultaForm) {
        if (!consultaRepository.medicoSelecionadoEstaDisponivel(id, consultaForm.getDataHorario(),
                consultaForm.getDataHorario().plusHours(1)).isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Medico nao possui disponibilidade");
        }
    }

}
