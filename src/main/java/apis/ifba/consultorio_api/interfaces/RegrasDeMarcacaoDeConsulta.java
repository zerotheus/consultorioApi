package apis.ifba.consultorio_api.interfaces;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import apis.ifba.consultorio_api.Dtos.Forms.ConsultaForm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegrasDeMarcacaoDeConsulta implements Regra {

    private ConsultaForm consultaForm;

    @Override
    public boolean validar() throws Exception {
        return tempoDeAtecedenciaEstaDentroDoPrazo(consultaForm.getDataHorario())
                && dentroDosDiasDeFuncionamento(consultaForm.getDataHorario())
                && dentroDosHorariosDeFuncionamento(consultaForm.getDataHorario());
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

}
