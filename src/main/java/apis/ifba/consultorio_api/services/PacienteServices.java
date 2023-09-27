package apis.ifba.consultorio_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.ifba.consultorio_api.Adapter.PacienteAdapter;
import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.repository.PacienteRepository;

@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastraPaciente(PacienteForm pacienteForm) {
        PacienteAdapter pacienteAdapter = new PacienteAdapter(pacienteForm);
        return pacienteRepository.save(pacienteAdapter.convertePacienteForm());
    }

}
