package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.model.campos.Email;

public interface RegrasDePessoas extends Regra {

    public boolean emailPermaneceInalterado(Email email, String novoEmail) throws Exception;

}
