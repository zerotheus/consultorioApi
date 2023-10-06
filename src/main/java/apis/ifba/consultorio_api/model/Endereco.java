package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
    @Column(name = "Endereco_Id")
    private Long id;
    private Long numero;
    private String uf;
    private String complemento;
    private String bairro;
    private String cidade;
    @Column(unique = true)
    private String cep;
    private String logradouro;

    @CreationTimestamp
    private LocalTime created;
    @UpdateTimestamp
    private LocalTime update;

}
