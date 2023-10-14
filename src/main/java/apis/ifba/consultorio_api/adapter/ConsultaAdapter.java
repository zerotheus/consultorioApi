package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import apis.ifba.consultorio_api.enums.EstadoConsulta;
import apis.ifba.consultorio_api.model.Consulta;
import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.model.Paciente;

public class ConsultaAdapter {

    private ConsultaForm consultaForm;

    public ConsultaAdapter(ConsultaForm consultaForm) {
        this.consultaForm = consultaForm;
    }

    public Consulta converteConsulta(Paciente pessoa, Medico medico) {
        Consulta consulta = new Consulta();
        consulta.setHorario(consultaForm.getDataHorario());
        consulta.setMedico(medico);
        consulta.setPaciente(pessoa);
        consulta.setEstado(EstadoConsulta.Agendada);
        return consulta;
    }

}
