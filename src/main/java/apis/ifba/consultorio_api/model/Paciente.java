package apis.ifba.consultorio_api.model;

import apis.ifba.consultorio_api.model.campos.CPF;
import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "Pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosCadastrais dadosCadastrais;
    @Embedded
    private CPF cpf;
    @ManyToOne
    private Endereco endereco;

}
