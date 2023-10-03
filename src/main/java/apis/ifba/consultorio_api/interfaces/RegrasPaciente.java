package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.model.campos.CPF;
import apis.ifba.consultorio_api.model.campos.Email;

public class RegrasPaciente implements RegrasEspecificasDePaciente {

    private Paciente paciente;
    private PacienteForm pacienteForm;

    public RegrasPaciente(Paciente paciente, PacienteForm pacienteForm) {
        this.paciente = paciente;
        this.pacienteForm = pacienteForm;
    }

    @Override
    public boolean emailPermaneceInalterado(Email email, String novoEmail) throws Exception {
        final String emailString = email.getEmail();
        System.out.println(emailString);
        System.out.println(novoEmail);
        if (!emailString.equals(novoEmail)) {
            throw new Exception("Email nao pode ser alterado");
        }
        return true;
    }

    // Bad smell na parte do email
    @Override
    public boolean validar() throws Exception {
        return cpfPermaneceInalterado(paciente.getCpf(), pacienteForm.getCPF())
                && emailPermaneceInalterado(paciente.getPessoa().getEmail(),
                        pacienteForm.getPessoa().getDadosCadastrais().getEmail());
    }

    @Override
    public boolean cpfPermaneceInalterado(CPF cpf, String cpfNovo) throws Exception {
        final String cpfString = cpf.getCpf();
        if (!cpfString.equals(cpfNovo)) {
            throw new Exception("CPF nao pode ser alterado");
        }
        return true;
    }

}
