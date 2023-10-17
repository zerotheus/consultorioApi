package apis.ifba.consultorio_api.Dtos.Forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CancelamentoForm {

    private Long consultaId;
    private String motivo;

}
