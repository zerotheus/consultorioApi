package apis.ifba.consultorio_api.Dtos.Forms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PessoaForm {

    private final DadosCadastraisForm dadosCadastrais;
    private final EnderecoForm endereco;

    @JsonCreator
    public PessoaForm(@JsonProperty("dadosCadastrais") DadosCadastraisForm dadosCadastrais,
            @JsonProperty("endereco") EnderecoForm endereco) {
        this.dadosCadastrais = dadosCadastrais;
        this.endereco = endereco;
    }

}
