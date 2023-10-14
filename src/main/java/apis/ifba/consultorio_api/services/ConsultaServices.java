package apis.ifba.consultorio_api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import apis.ifba.consultorio_api.adapter.ConsultaAdapter;
import apis.ifba.consultorio_api.interfaces.RegrasDeMarcacaoDeConsulta;
import apis.ifba.consultorio_api.model.Consulta;
import apis.ifba.consultorio_api.repository.ConsultaRepository;
import apis.ifba.consultorio_api.repository.PacienteRepository;

@Service
public class ConsultaServices {

    @Autowired
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;

    public ResponseEntity<Consulta> marcaConsulta(ConsultaForm consultaForm) {
        Consulta consulta = converteParaConsulta(consultaForm);
        estaDentroDasRegras(consultaForm);
        return ResponseEntity.created(null).body(consulta);
    }

    private Consulta converteParaConsulta(ConsultaForm consultaForm) {
        ConsultaAdapter consultaAdapter = new ConsultaAdapter(consultaForm);
        return consultaAdapter.converteConsulta(null, null);// TODO procurar medico e Paciente
    }

    private void estaDentroDasRegras(ConsultaForm consultaForm) {
        RegrasDeMarcacaoDeConsulta regras = new RegrasDeMarcacaoDeConsulta(consultaForm);
        try {
            regras.validar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.toString());
        }
    }

}
