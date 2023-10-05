package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.model.Endereco;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnderecoDTO {

    private final Long numero;
    private final String uf;
    private final String complemento;
    private final String bairro;
    private final String cidade;
    private final String cep;
    private final String logradouro;

    EnderecoDTO(Endereco endereco) {
        this.numero = endereco.getNumero();
        this.uf = endereco.getUf();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
    }

}
