package apis.ifba.consultorio_api.model;

import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Pessoas")
// @Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosCadastrais dadosCadastrais;
    @ManyToOne
    private Endereco endereco;
}
