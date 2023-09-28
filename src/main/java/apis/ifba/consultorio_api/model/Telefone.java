package apis.ifba.consultorio_api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    private String telefone;

    @Override
    public String toString() {
        return this.getTelefone();
    }

    

}
