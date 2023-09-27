package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.EnderecoForm;
import apis.ifba.consultorio_api.model.Endereco;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnderecoAdapter {
    private EnderecoForm endereco;

    public Endereco converteParaEndereco() {
        Endereco endereco = new Endereco();
        endereco.setBairro(this.endereco.getBairro());
        endereco.setCep(this.endereco.getCep());
        endereco.setCidade(this.endereco.getCidade());
        endereco.setComplemento(this.endereco.getComplemento());
        endereco.setNumero(this.endereco.getNumero());
        endereco.setUf(this.endereco.getUf());
        return endereco;
    }
}
