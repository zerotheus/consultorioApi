package apis.ifba.consultorio_api.Dtos.Forms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PacienteForm {

    private final PessoaForm pessoa;
    private final CPFForm cpf;

    @JsonCreator
    public PacienteForm(@JsonProperty("pessoa") PessoaForm pessoa, @JsonProperty("CPF") CPFForm cpf) {
        this.pessoa = pessoa;
        this.cpf = cpf;
        
    }

}
