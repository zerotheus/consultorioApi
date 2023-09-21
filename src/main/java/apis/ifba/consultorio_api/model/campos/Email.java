package apis.ifba.consultorio_api.model.campos;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Email {

    private String email;

}
