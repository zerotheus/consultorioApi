package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DadosCadastraisDTO {

    private final String nome;
    private final String telefone;
    private final String email;

    DadosCadastraisDTO(DadosCadastrais dadosCadastrais) {

        this.nome = dadosCadastrais.getNome();
        this.email = dadosCadastrais.getEmail().getEmail();
        this.telefone = dadosCadastrais.getTelefone().getTelefone();

    }

}
