package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.DadosCadastraisForm;
import apis.ifba.consultorio_api.model.Telefone;
import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import apis.ifba.consultorio_api.model.campos.Email;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DadosCadastraisAdapter {

    private DadosCadastraisForm dadosCadastraisForm;

    public DadosCadastrais converteParaDadosCadastrais() {
        return new DadosCadastrais(new Email(this.dadosCadastraisForm.getEmail()),
                new Telefone(this.dadosCadastraisForm.getTelefone()), this.dadosCadastraisForm.getNome());
    }

}
