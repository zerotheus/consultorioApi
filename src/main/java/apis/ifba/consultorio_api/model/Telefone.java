package apis.ifba.consultorio_api.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Telefone {

    private String telefone;

}
