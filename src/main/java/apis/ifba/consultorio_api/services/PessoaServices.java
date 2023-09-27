package apis.ifba.consultorio_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.ifba.consultorio_api.model.Endereco;
import apis.ifba.consultorio_api.model.Pessoa;
import apis.ifba.consultorio_api.repository.EnderecoRepository;
import apis.ifba.consultorio_api.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PessoaServices {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa cadastraPessoa(Pessoa pessoa) {
        /*
         * if (pessoaJaCadastrada(pessoa)) {
         * return pessoa;
         * }
         */
        cadastraEndereco(pessoa.getEndereco());
        return pessoaRepository.save(pessoa);
    }

    public Boolean pessoaJaCadastrada(Pessoa pessoa) {
        System.out.println(pessoa.getDadosCadastrais().getEmail().toString());
        Pessoa pessoaEncontrada = pessoaRepository.findByEmail(pessoa.getDadosCadastrais().getEmail().toString());
        if (pessoaEncontrada != null) {
            pessoa = pessoaEncontrada;
            System.out.println(pessoaEncontrada);
            return true;
        }
        return false;
    }

    private Endereco cadastraEndereco(Endereco endereco) {
        // System.out.println("Endereco\n" + endereco + "\n");
        return enderecoRepository.save(endereco);
    }

}
