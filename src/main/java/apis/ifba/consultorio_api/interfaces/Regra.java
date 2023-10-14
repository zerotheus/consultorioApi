package apis.ifba.consultorio_api.interfaces;

import apis.ifba.consultorio_api.model.campos.Email;

public interface Regra {

    public boolean validar() throws Exception;
}
