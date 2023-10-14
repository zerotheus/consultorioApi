package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.enums.Especialidade;

public interface RegrasEspecificasMedico extends RegrasDePessoas {

    public boolean crmPermaneceInalterado(String CRM, String novoCRM) throws Exception;

    public boolean especilidadePermaneceInalterada(Especialidade especialidade, Especialidade novaEspecialidade)
            throws Exception;

}
