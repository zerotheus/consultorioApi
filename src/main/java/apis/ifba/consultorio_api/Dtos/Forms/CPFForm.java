package apis.ifba.consultorio_api.Dtos.Forms;

import apis.ifba.consultorio_api.interfaces.ValidacaodeCPF;
import lombok.Getter;

@Getter
public class CPFForm implements ValidacaodeCPF {

    private final String cpf;

    CPFForm(String cpf) throws Exception {
        // validaCPF(cpf);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return this.getCpf();
    }

    

}
