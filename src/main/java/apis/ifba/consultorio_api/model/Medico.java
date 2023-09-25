package apis.ifba.consultorio_api.model;

import apis.ifba.consultorio_api.enums.Especialidade;
import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "medicos")
@Setter
@Getter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pessoa pessoa;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String CRM;

}
