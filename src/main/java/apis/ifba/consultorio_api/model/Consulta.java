package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
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

    @CreationTimestamp
    private LocalTime created;
    @UpdateTimestamp
    private LocalTime update;

}
