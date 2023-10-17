package apis.ifba.consultorio_api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.CancelamentoForm;
import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import apis.ifba.consultorio_api.Dtos.dto.ConsultaDTO;
import apis.ifba.consultorio_api.model.Consulta;
import apis.ifba.consultorio_api.repository.ConsultaRepository;
import apis.ifba.consultorio_api.repository.PacienteRepository;
import apis.ifba.consultorio_api.services.ConsultaServices;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Consulta")
@AllArgsConstructor
public class ConsultaController {

    private ConsultaServices consultaServices;

    @PostMapping("/Agendar")
    public ResponseEntity<ConsultaDTO> marcaConsulta(@RequestBody ConsultaForm consulta) {
        return ResponseEntity.created(null).body(new ConsultaDTO(consultaServices.marcaConsulta(consulta)));
    }

    @DeleteMapping("/Cancelar")
    public ResponseEntity<Object> cancelaConsulta(@RequestBody CancelamentoForm cancelamentoForm) {
        consultaServices.cancelar(cancelamentoForm);
        return ResponseEntity.ok().build();
    }

}
