package apis.ifba.consultorio_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return pacienteServices.cadastraPaciente(paciente);
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<Paciente> editaPaciente(@PathVariable Long id, @RequestBody PacienteForm paciente) {
        return null;
    }

}
