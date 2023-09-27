package apis.ifba.consultorio_api.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;
import apis.ifba.consultorio_api.model.Paciente;
import apis.ifba.consultorio_api.services.PacienteServices;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {

    @Autowired
    private PacienteServices pacienteServices;

    @PostMapping("/Register")
    public ResponseEntity<Paciente> cadastraPaciente(@RequestBody PacienteForm paciente) {
        return ResponseEntity.created(null).body(pacienteServices.cadastraPaciente(paciente));
    }

}
