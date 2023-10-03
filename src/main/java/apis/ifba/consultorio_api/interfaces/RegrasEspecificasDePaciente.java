package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.model.campos.CPF;

public interface RegrasEspecificasDePaciente extends Regra {

    public boolean cpfPermaneceInalterado(CPF cpf, String cpfNovo) throws Exception;

}
