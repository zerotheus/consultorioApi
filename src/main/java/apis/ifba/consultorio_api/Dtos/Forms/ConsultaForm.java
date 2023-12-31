package apis.ifba.consultorio_api.Dtos.Forms;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaForm {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHorario;
    private Long medicoId;
    private Long pacienteId;

}
