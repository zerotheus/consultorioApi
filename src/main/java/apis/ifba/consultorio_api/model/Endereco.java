package apis.ifba.consultorio_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Enderecos")
@Setter
@Getter
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero;
    private String uf;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String logradouro;
    // @OneToMany(fetch = FetchType.LAZY)
    // private List<Pessoa> pessoas;

}
