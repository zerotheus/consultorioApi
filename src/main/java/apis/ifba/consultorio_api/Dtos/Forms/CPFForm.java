package apis.ifba.consultorio_api.Dtos.Forms;

import apis.ifba.consultorio_api.interfaces.ValidacaodeCPF;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CPFForm implements ValidacaodeCPF {

    private final String cpf;

    CPFForm(String cpf) throws Exception {
        // validaCPF(cpf);
        this.cpf = cpf;
    }

}
