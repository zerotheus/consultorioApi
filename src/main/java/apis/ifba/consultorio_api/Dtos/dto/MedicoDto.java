package apis.ifba.consultorio_api.Dtos.dto;

import apis.ifba.consultorio_api.enums.Especialidade;
import apis.ifba.consultorio_api.model.Medico;

public class MedicoDto {

    private final Especialidade especialidade;
    private final String CRM;
    private final PessoaDTO pessoa;

    public MedicoDto(Medico medico) {
        this.especialidade = medico.getEspecialidade();
        this.CRM = medico.getCRM();
        this.pessoa = new PessoaDTO(medico.getPessoa());
    }

}
