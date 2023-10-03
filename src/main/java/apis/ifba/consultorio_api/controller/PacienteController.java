package apis.ifba.consultorio_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        return pacienteServices.editaPaciente(id, paciente);
    }

    @GetMapping("{id}")
    public ResponseEntity<Paciente> editaPaciente(@PathVariable Long id) {
        return pacienteServices.encontraPacientePeloId(id);
    }

    @DeleteMapping("/Deleta/{id}")
    public ResponseEntity<Object> deletaPaciente(@PathVariable Long id) {
        return pacienteServices.apagaPaciente(id);
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<Page<Paciente>> listaPacientes(@PathVariable int page) {
        // Pageable pageable = PageRequest.of(page, 10);
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "pessoa.dadosCadastrais.nome"));
        return ResponseEntity.ok().body(pacienteServices.listaPacientes(pageable));
    }

}
