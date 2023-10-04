package apis.ifba.consultorio_api.adapter;

import apis.ifba.consultorio_api.Dtos.Forms.MedicoForm;
import apis.ifba.consultorio_api.model.Medico;

public class MedicoAdapter {

    private MedicoForm medicoForm;

    public MedicoAdapter(MedicoForm medicoForm) {
        this.medicoForm = medicoForm;
    }

    public Medico converteMedicoForm() {
        Medico medico = new Medico();
        medico.setCRM(medicoForm.getCrm());
        medico.setEspecialidade(medicoForm.getEspecialidade());
        medico.setStatus(true);
        PessoaAdapter pessoaAdapter = new PessoaAdapter(this.medicoForm.getPessoa());
        medico.setPessoa(pessoaAdapter.convertePessoaFormParaPessoa());
        return medico;
    }

}
