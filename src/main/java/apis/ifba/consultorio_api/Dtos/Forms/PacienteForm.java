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

    public String getCPF() {
        return this.cpf.toString();
    }

    public String getNome() {
        return this.pessoa.getNome();
    }

    public String getTelefone() {
        return this.pessoa.getTelefone();
    }

    public String getEmail() {
        return this.pessoa.getEmail();
    }

}
