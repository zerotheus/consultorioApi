package apis.ifba.consultorio_api.interfaces;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegrasDeMarcacaoDeConsulta implements Regra {

    private ConsultaForm consultaForm;

    @Override
    public boolean validar() throws Exception {
        return tempoDeAtecedenciaEstaDentroDoPrazo(consultaForm.getDataHorario())
                && dentroDosDiasDeFuncionamento(consultaForm.getDataHorario())
                && dentroDosHorariosDeFuncionamento(consultaForm.getDataHorario())
                && temUmaHoraDisponivel(consultaForm.getDataHorario());
    }

    private boolean tempoDeAtecedenciaEstaDentroDoPrazo(LocalDateTime horaMarcada) throws Exception {
        if (horaMarcada.compareTo(LocalDateTime.now().plusMinutes(30)) <= 0) {
            throw new Exception("Requerimos 30 minutos de atecedencia");
        }
        return true;
    }

    private boolean dentroDosDiasDeFuncionamento(LocalDateTime horaMarcada) throws Exception {
        if (horaMarcada.getDayOfWeek() == DayOfWeek.SATURDAY) {
            throw new Exception("Funcionamos de Segunda a Sexta");
        }
        return true;
    }

    private boolean dentroDosHorariosDeFuncionamento(LocalDateTime horaMarcada) throws Exception {
        if (horaMarcada.isBefore(horaMarcada.withHour(7).withMinute(0).withSecond(0))
                || horaMarcada.isAfter(horaMarcada.withHour(19).withMinute(0).withSecond(0))) {
            throw new Exception("Funcionamos de Segunda a Sexta das 7 as 19");
        }
        return true;
    }

    private boolean temUmaHoraDisponivel(LocalDateTime horaMarcada) {
        if (horaMarcada.plusHours(1).isAfter(horaMarcada.withHour(19).withMinute(00))) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "O prazo estimado excede as 19 horas");
        }
        return true;
    }

}
