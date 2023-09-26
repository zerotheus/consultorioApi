package apis.ifba.consultorio_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.PacienteForm;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {

    @PostMapping("/Register")
    public String cadastraPaciente(@RequestBody PacienteForm paciente) {
        System.out.println(paciente);
        return paciente.toString();
    }

}
