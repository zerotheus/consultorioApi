package apis.ifba.consultorio_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apis.ifba.consultorio_api.Dtos.Forms.MedicoForm;
import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.Dtos.dto.MedicoDto;
import apis.ifba.consultorio_api.adapter.MedicoAdapter;
import apis.ifba.consultorio_api.interfaces.Regra;
import apis.ifba.consultorio_api.interfaces.RegrasMedico;
import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.model.Pessoa;
import apis.ifba.consultorio_api.repository.MedicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicoServices {

    @Autowired
    private MedicoRepository medicoRepository;
    private PessoaServices pessoaServices;

    public ResponseEntity<MedicoDto> cadastraMedico(MedicoForm medicoForm) {
        Medico medico = adaptaFormularioDeMedico(medicoForm);
        if (jaPossuiCadastro(medico)) {
            if (cadastroEstaRelacionadoComOutroMedico(medico)) {
                throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Esta Pessoa ja esta cadastrada");
            }
        }
        pessoaServices.cadastraPessoa(medico.getPessoa());
        medicoRepository.save(medico);
        return ResponseEntity.created(null).body(new MedicoDto(medico));
    }

    public boolean jaPossuiCadastro(Medico medico) {
        Optional<Pessoa> pessoaEncontrada = pessoaServices.pessoaJaCadastrada(medico.getPessoa());
        if (pessoaEncontrada.isPresent()) {
            medico.setPessoa(pessoaEncontrada.get());
            return true;
        }
        return false;
    }

    private boolean cadastroEstaRelacionadoComOutroMedico(Medico medico) {
        return medicoRepository.findByPessoa(medico.getPessoa()).isPresent();
    }

    public ResponseEntity<MedicoDto> editaMedico(Long id, MedicoForm medicoFormComEdicoes) {
        Optional<Medico> medicoAserEditado = medicoRepository.findById(id);
        if (medicoAserEditado.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        try {
            validaEdicoes(medicoAserEditado.get(), medicoFormComEdicoes);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.toString());
        }
        final Medico medicoComEdicoes = adaptaFormularioDeMedico(medicoFormComEdicoes);
        System.out.println(medicoComEdicoes);
        // bad smell
        final Pessoa pessoaComEdicoes = pessoaServices.editaPessoa(medicoAserEditado.get().getPessoa().getId(),
                medicoAserEditado.get().getPessoa());
        // Pq as pessoas gostam disso abaixo?
        return medicoAserEditado.map(medicoEmEdicao -> {
            medicoEmEdicao.setCRM(medicoComEdicoes.getCRM());
            medicoEmEdicao.setPessoa(pessoaComEdicoes);
            medicoEmEdicao.setEspecialidade(medicoComEdicoes.getEspecialidade());
            medicoRepository.save(medicoEmEdicao);
            System.out.println(medicoEmEdicao);
            return ResponseEntity.created(null).body(new MedicoDto(medicoComEdicoes));
        }).orElse(ResponseEntity.badRequest().build());
    }

    private void validaEdicoes(Medico medico, MedicoForm medicoForm) throws Exception {
        Regra regrasDeMedico = new RegrasMedico(medico, medicoForm);
        regrasDeMedico.validar();
    }

    private Medico adaptaFormularioDeMedico(MedicoForm medicoForm) {
        MedicoAdapter medicoAdapter = new MedicoAdapter(medicoForm);
        return medicoAdapter.converteMedicoForm();
    }

    public ResponseEntity<MedicoDto> encontraUmMedico(Long id) {
        return medicoRepository.findByIdAndStatus(id, true).map(medico -> {
            return ResponseEntity.ok().body(new MedicoDto(medico));
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> apagaMedico(Long id) {
        Optional<Medico> medicoAserEditado = medicoRepository.findById(id);
        if (medicoAserEditado.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        // Pq as pessoas gostam disso abaixo?
        return medicoAserEditado.map(medicoEmEdicao -> {
            medicoEmEdicao.setStatus(false);
            medicoRepository.save(medicoEmEdicao);
            System.out.println(medicoEmEdicao);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.badRequest().build());
    }

    public Page<MedicoDto> listaMedicos(Pageable pageable) {
        return medicoRepository.findAll(pageable).map(MedicoDto::new);
    }

    public List<Long> listaTodosMedicosDisponiveis() {
        return medicoRepository.findAllAvaliable();
    }

}
