package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.enums.Especialidade;
import apis.ifba.consultorio_api.model.campos.Email;

public class RegrasMedico implements RegrasEspecificasMedico {

    @Override
    public boolean emailPermaneceInalterado(Email email, String novoEmail) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emailPermaneceInalterado'");
    }

    @Override
    public boolean validar() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validar'");
    }

    @Override
    public boolean crmPermaneceInalterado(String CRM, String novoCRM) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crmPermaneceInalterado'");
    }

    @Override
    public boolean especilidadePermaneceInalterada(Especialidade especialidade, Especialidade novaEspecialidade)
            throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'especilidadePermaneceInalterada'");
    }

}
