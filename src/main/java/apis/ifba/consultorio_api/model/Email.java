package apis.ifba.consultorio_api.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Email {

    private String email;

}
