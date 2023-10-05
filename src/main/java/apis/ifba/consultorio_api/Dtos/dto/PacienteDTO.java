package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.model.Paciente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PacienteDTO {

    private final String cpf;
    private final PessoaDTO pessoa;

    public PacienteDTO(Paciente paciente) {
        this.cpf = paciente.getCpf().toString();
        this.pessoa = new PessoaDTO(paciente.getPessoa());
    }

}
