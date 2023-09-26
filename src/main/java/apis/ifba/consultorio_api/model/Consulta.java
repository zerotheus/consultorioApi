package apis.ifba.consultorio_api.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Consulta {
    @Id
    private Long id;
    @OneToOne
    private Medico medico;
    @OneToOne
    private Paciente paciente;
    private LocalTime horario;

}
