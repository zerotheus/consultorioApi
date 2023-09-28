package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.model.campos.CPF;

public class PacienteAdapter {

    private PacienteForm paciente;

    public PacienteAdapter(PacienteForm paciente) {
        this.paciente = paciente;
    }

    public Paciente convertePacienteForm() {
        Paciente paciente = new Paciente();
        paciente.setCpf(new CPF(this.paciente.getCPF()));
        PessoaAdapter pessoaAdapter = new PessoaAdapter(this.paciente.getPessoa());
        paciente.setPessoa(pessoaAdapter.convertePessoaFormParaPessoa());
        return paciente;
    }

}
