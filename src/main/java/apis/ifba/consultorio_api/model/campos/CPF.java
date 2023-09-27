package apis.ifba.consultorio_api.model.campos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class CPF {

    private String cpf;

}
