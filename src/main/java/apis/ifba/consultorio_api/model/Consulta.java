package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import apis.ifba.consultorio_api.enums.EstadoConsulta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Consultas")
@Getter
@Setter
public class Consulta {
    @Id
    @Column(name = "consulta_id")
    private Long id;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "Fk_medico_id")
    private Medico medico;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "Fk_paciente_id")
    private Paciente paciente;
    private LocalTime horario;
    @Enumerated(EnumType.STRING)
    private EstadoConsulta estado;

    @CreationTimestamp
    private LocalTime created;
    @UpdateTimestamp
    private LocalTime update;

}
