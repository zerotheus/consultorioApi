package apis.ifba.consultorio_api.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;

@RestController
@RequestMapping("/Consulta")
public class ConsultaController {

    @PostMapping("/Agendar")
    public ConsultaForm marcaConsulta(@RequestBody ConsultaForm consulta) {
        ConsultaForm consultaForm = new ConsultaForm();
        System.out.println(consulta.getDataHorario().getMonthValue());
        System.out.println(consulta.getDataHorario());
        return consulta;
    }

}
