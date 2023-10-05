package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.model.campos.DadosCadastrais;

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
