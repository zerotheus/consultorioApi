package apis.ifba.consultorio_api.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import apis.ifba.consultorio_api.enums.EstadoConsulta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Consultas")
@Getter
@Setter
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "consulta_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FK_Medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "FK_Paciente_id")
    private Paciente paciente;
    private LocalDateTime horario;
    @Enumerated(EnumType.STRING)
    private EstadoConsulta estado;

    @CreationTimestamp
    private LocalTime created;
    @UpdateTimestamp
    private LocalTime update;

}
