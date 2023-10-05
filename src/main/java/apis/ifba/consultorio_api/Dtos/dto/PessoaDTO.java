package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.model.Pessoa;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PessoaDTO {

    private final DadosCadastraisDTO dadosCadastrais;
    private final EnderecoDTO endereco;

    PessoaDTO(Pessoa pessoa) {
        this.dadosCadastrais = new DadosCadastraisDTO(pessoa.getDadosCadastrais());
        this.endereco = new EnderecoDTO(pessoa.getEndereco());
    }

}
