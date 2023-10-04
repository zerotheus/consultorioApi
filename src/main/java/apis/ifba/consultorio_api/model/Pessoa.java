package apis.ifba.consultorio_api.model;

import apis.ifba.consultorio_api.model.campos.DadosCadastrais;
import apis.ifba.consultorio_api.model.campos.Email;
import jakarta.persistence.Column;
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
@Table(uniqueConstraints = @UniqueConstraint(name = "Email unico", columnNames = "email"))
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_Id")
    private Long id;
    @Embedded
    private DadosCadastrais dadosCadastrais;
    @ManyToOne
    private Endereco endereco;

    public Email getEmail() {
        return this.getDadosCadastrais().getEmail();
    }
}
