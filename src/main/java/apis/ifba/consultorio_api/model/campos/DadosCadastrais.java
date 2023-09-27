package apis.ifba.consultorio_api.model.campos;

import apis.ifba.consultorio_api.model.Telefone;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class DadosCadastrais {
    @Embedded
    private Email email;
    @Embedded
    private Telefone telefone;
    private String nome;
}
