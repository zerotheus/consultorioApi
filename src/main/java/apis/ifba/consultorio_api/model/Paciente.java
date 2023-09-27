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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Pacientes")
@Setter
@Getter
@ToString
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pessoa pessoa;
    @Embedded
    private CPF cpf;

}
