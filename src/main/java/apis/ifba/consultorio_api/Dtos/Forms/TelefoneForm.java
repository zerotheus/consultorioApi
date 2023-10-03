package apis.ifba.consultorio_api.Dtos.Forms;

import lombok.Getter;

@Getter
public class TelefoneForm {

    private final String telefone;

    public TelefoneForm(String telefone) throws Exception {
        temSomenteNumeros(telefone);
        this.telefone = telefone;
    }

    private boolean temSomenteNumeros(String telefone) throws Exception {
        for (int i = 0; i < telefone.length(); i++) {
            if (!ehUmNumero(telefone.charAt(i))) {
                throw new Exception("TeleFone tem somente numeros");
            }
        }
        return true;
    }

    private boolean ehUmNumero(char digito) {
        return Character.isDigit(digito);
    }

    @Override
    public String toString() {
        return this.getTelefone();
    }

}
