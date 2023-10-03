package apis.ifba.consultorio_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.MedicoForm;
import apis.ifba.consultorio_api.model.Medico;

@RestController
@RequestMapping("/Medico")
public class MedicoController {

    @PostMapping("/Register")
    public MedicoForm cadastraMedico(@RequestBody MedicoForm medico) {
        return medico;
    }

}
