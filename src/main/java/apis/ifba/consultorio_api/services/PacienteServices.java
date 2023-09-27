package apis.ifba.consultorio_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.adapter.PacienteAdapter;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.repository.PacienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PacienteServices {

    @Autowired
    private PacienteRepository pacienteRepository;
    private PessoaServices pessoaServices;

    public Paciente cadastraPaciente(PacienteForm pacienteForm) {
        PacienteAdapter pacienteAdapter = new PacienteAdapter(pacienteForm);
        Paciente paciente = pacienteAdapter.convertePacienteForm();
        pessoaServices.cadastraPessoa(paciente.getPessoa());
        return pacienteRepository.save(paciente);
    }

}
