package apis.ifba.consultorio_api.Dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import apis.ifba.consultorio_api.interfaces.ValidacaodeCPF;

public class CPFForm implements ValidacaodeCPF {

    private final String cpf;

    @JsonCreator
    CPFForm(String cpf) throws Exception {
        validaCPF(cpf);
        this.cpf = cpf;
    }

}
