package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.PessoaForm;
import apis.ifba.consultorio_api.model.Pessoa;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PessoaAdapter {

    private PessoaForm pessoa;

    public Pessoa convertePessoaFormParaPessoa() {
        Pessoa pessoa = new Pessoa();
        adaptaDadosCadastrais(pessoa);
        adaptaEndereco(pessoa);
        return pessoa;
    }

    private void adaptaDadosCadastrais(Pessoa pessoa) {
        DadosCadastraisAdapter dadosCadastraisAdapter = new DadosCadastraisAdapter(this.pessoa.getDadosCadastrais());
        pessoa.setDadosCadastrais(dadosCadastraisAdapter.converteParaDadosCadastrais());
    }

    private void adaptaEndereco(Pessoa pessoa) {
        EnderecoAdapter enderecoAdapter = new EnderecoAdapter(this.pessoa.getEndereco());
        pessoa.setEndereco(enderecoAdapter.converteParaEndereco());
    }

}
