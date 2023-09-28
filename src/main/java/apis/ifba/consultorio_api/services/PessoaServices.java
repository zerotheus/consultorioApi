package apis.ifba.consultorio_api.services;

import java.util.Optional;

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
        if (pessoaJaCadastrada(pessoa).isPresent()) {
            return pessoa;
        }
        cadastraEndereco(pessoa.getEndereco());
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> pessoaJaCadastrada(Pessoa pessoa) {
        // System.out.println(pessoa.getDadosCadastrais().getEmail().toString());
        Optional<Pessoa> pessoaEncontrada = pessoaRepository
                .findByEmail(pessoa.getDadosCadastrais().getEmail().toString());
        if (pessoaEncontrada.isPresent()) {
            pessoa = pessoaEncontrada.get();
            return pessoaEncontrada;
        }
        return null;
    }

    private Endereco cadastraEndereco(Endereco endereco) {
        // System.out.println("Endereco\n" + endereco + "\n");
        return enderecoRepository.save(endereco);
    }

    public Optional<Pessoa> encontraPessoaPeloId(Long id) {
        return pessoaRepository.findById(id);
    }

    // Como pessoa esta é uma entidade necessaria para existir tanto medico quanto
    // paciente recebo a pessoa diretamente
    public Pessoa editaPessoa(Long id, Pessoa edicoesParaPessoa) {
        Optional<Pessoa> pessoaASerEditada = encontraPessoaPeloId(id);
        return pessoaASerEditada.map(pessoaEmEdicao -> {
            pessoaEmEdicao.setDadosCadastrais(edicoesParaPessoa.getDadosCadastrais());
            pessoaEmEdicao.setEndereco(edicoesParaPessoa.getEndereco());
            enderecoRepository.save(edicoesParaPessoa.getEndereco());
            pessoaRepository.save(pessoaEmEdicao);
            return pessoaEmEdicao;
        }).orElse(null);
    }

    private Endereco enderecoJaEstaCadastrado(Endereco endereco) {
        return null;
    }

}
