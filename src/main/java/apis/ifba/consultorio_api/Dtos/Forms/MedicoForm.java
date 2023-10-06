package apis.ifba.consultorio_api.Dtos.Forms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import apis.ifba.consultorio_api.enums.Especialidade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class MedicoForm {

    private final PessoaForm pessoa;
    @Enumerated(EnumType.STRING)
    private final Especialidade especialidade;
    private final String crm;

    @JsonCreator
    public MedicoForm(@JsonProperty("pessoa") PessoaForm pessoa,
            @JsonProperty("especialidade") Especialidade especialidade, @JsonProperty("crm") String crm) {
        this.pessoa = pessoa;
        this.especialidade = especialidade;
        this.crm = crm;
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
