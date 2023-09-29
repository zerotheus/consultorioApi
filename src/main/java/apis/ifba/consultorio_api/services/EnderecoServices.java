package apis.ifba.consultorio_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.ifba.consultorio_api.model.Endereco;
import apis.ifba.consultorio_api.repository.EnderecoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoServices {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastraEndereco(Endereco endereco) {
        final Optional<Endereco> enderecoProcurado = enderecoJaEstaCadastrado(endereco);
        if (enderecoProcurado.isPresent()) {
            return enderecoProcurado.get();
        }
        return enderecoRepository.save(endereco);
    }

    private Optional<Endereco> enderecoJaEstaCadastrado(Endereco endereco) {
        return enderecoRepository.findByCep(endereco.getCep());
    }

}
