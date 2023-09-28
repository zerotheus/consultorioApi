package apis.ifba.consultorio_api.Dtos.Forms;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Embeddable
public class DadosCadastraisForm {
    private final String email;
    private final TelefoneForm telefone;
    private final String nome;

    @JsonCreator
    public DadosCadastraisForm(String email, String telefone, String nome) throws Exception {
        this.email = email;
        this.telefone = new TelefoneForm(telefone);
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone.toString();
    }

}
