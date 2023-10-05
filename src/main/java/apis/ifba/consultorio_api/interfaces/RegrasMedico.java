package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.Dtos.Forms.MedicoForm;
import apis.ifba.consultorio_api.enums.Especialidade;
import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.model.campos.Email;

public class RegrasMedico implements RegrasEspecificasMedico {

    private Medico medico;
    private MedicoForm medicoForm;

    public RegrasMedico(Medico medico, MedicoForm medicoForm) {
        this.medico = medico;
        this.medicoForm = medicoForm;
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

    @Override
    public boolean validar() throws Exception {
        return emailPermaneceInalterado(medico.getEmail(),
                medicoForm.getPessoa().getDadosCadastrais().getEmail())
                && crmPermaneceInalterado(medico.getCRM(), medicoForm.getCrm())
                && especilidadePermaneceInalterada(medico.getEspecialidade(), medicoForm.getEspecialidade());
    }

    @Override
    public boolean crmPermaneceInalterado(String CRM, String novoCRM) throws Exception {
        if (!CRM.equals(novoCRM)) {
            throw new Exception("Email nao pode ser alterado");
        }
        return true;
    }

    @Override
    public boolean especilidadePermaneceInalterada(Especialidade especialidade, Especialidade novaEspecialidade)
            throws Exception {
        if (!(especialidade == novaEspecialidade)) {
            throw new Exception("Especialidade nao pode ser alterada");
        }
        return true;
    }

}
