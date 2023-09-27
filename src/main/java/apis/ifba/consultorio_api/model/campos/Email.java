package apis.ifba.consultorio_api.model.campos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String email;

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }

}
