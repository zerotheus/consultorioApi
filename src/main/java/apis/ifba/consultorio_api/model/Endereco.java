package apis.ifba.consultorio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Enderecos")
@Table(uniqueConstraints = @UniqueConstraint(name = "Cep Unico", columnNames = { "cep" }))
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

}
