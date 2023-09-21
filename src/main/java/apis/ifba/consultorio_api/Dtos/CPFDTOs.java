package apis.ifba.consultorio_api.Dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

import apis.ifba.consultorio_api.interfaces.ValidacaodeCPF;

public class CPFDTOs implements ValidacaodeCPF {

    private String cpf;

    @JsonCreator
    CPFDTOs(String cpf) {
        validaCPF(cpf);
    }

}
