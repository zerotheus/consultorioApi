package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.model.campos.Email;

public interface Regra {
    public boolean emailPermaneceInalterado(Email email, String novoEmail) throws Exception;

    public boolean validar() throws Exception;
}
