package apis.ifba.consultorio_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.MedicoForm;
import apis.ifba.consultorio_api.model.Medico;
import apis.ifba.consultorio_api.services.MedicoServices;

@RestController
@RequestMapping("/Medico")
public class MedicoController {

    @Autowired
    private MedicoServices medicoServices;

    @PostMapping("/Register")
    public ResponseEntity<Medico> cadastraMedico(@RequestBody MedicoForm medico) {
        return medicoServices.cadastraMedico(medico);
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<Medico> editaMedico(@RequestBody MedicoForm medico, @PathVariable Long id) {
        System.out.println(medico);
        return medicoServices.editaMedico(id, medico);
    }

}
