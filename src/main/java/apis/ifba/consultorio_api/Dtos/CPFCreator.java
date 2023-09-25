package apis.ifba.consultorio_api.Dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import apis.ifba.consultorio_api.interfaces.ValidacaodeCPF;

public class CPFCreator implements ValidacaodeCPF {

    private final String cpf;

    @JsonCreator
    CPFCreator(String cpf) throws Exception {
        validaCPF(cpf);
        this.cpf = cpf;
    }

}
