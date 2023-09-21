package apis.ifba.consultorio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    @Id
    private Long numero;
    @Id
    private String uf;
    @Id
    private String complemento;
    @Id
    private String bairro;
    @Id
    private String cidade;
    @Id
    private String cep;
    @Id
    private String logradouro;

}
