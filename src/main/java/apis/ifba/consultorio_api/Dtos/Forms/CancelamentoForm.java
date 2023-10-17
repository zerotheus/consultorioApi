package apis.ifba.consultorio_api.Dtos.Forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelamentoForm {

    private Long consultaId;
    private String motivo;

}
