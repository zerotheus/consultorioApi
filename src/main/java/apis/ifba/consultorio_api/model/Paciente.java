package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import apis.ifba.consultorio_api.model.campos.CPF;
import apis.ifba.consultorio_api.model.campos.Email;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @Column(name = "Paciente_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "FK_Pessoa_id")
    private Pessoa pessoa;
    @Embedded
    private CPF cpf;
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
