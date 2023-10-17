package apis.ifba.consultorio_api.Dtos.dto;

import java.time.LocalDateTime;

import apis.ifba.consultorio_api.model.Consulta;

public class ConsultaDTO {

    private final LocalDateTime horario;
    private final MedicoDto medicoDto;
    private final PacienteDTO pacienteDTO;

    public ConsultaDTO(Consulta consulta) {

        this.horario = consulta.getHorario();
        this.medicoDto = new MedicoDto(consulta.getMedico());
        this.pacienteDTO = new PacienteDTO(consulta.getPaciente());

    }

}
