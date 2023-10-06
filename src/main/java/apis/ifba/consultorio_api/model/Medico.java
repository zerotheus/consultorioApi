package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import apis.ifba.consultorio_api.enums.Especialidade;
import apis.ifba.consultorio_api.model.campos.Email;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "medicos")
@Setter
@Getter
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pessoa pessoa;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String CRM;
    private Boolean status;

    @CreationTimestamp
    private LocalTime created;
    @UpdateTimestamp
    private LocalTime update;

    public Long getPessoaFK() {
        return this.getPessoa().getId();
    }

    public Email getEmail() {
        return this.getPessoa().getEmail();
    }

    public String getNome() {
        return this.getPessoa().getNome();
    }

    public Telefone getTelefone() {
        return this.getPessoa().getTelefone();
    }

}
