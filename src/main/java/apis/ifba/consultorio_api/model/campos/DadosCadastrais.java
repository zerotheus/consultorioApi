package apis.ifba.consultorio_api.model.campos;

import apis.ifba.consultorio_api.model.Telefone;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@AllArgsConstructor
@Getter
public class DadosCadastrais {
    @Embedded
    private Email email;
    @Embedded
    private Telefone telefone;
    private String nome;
}
