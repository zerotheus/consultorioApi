package apis.ifba.consultorio_api.Dtos;

public class TelefoneForm {

    private String telefone;

    public TelefoneForm(String telefone) throws Exception {
        temSomenteNumeros(telefone);
        this.telefone = telefone;
    }

    private boolean temSomenteNumeros(String telefone) throws Exception {
        for (int i = 0; i < telefone.length(); i++) {
            if (ehUmNumero(telefone.charAt(i))) {
                throw new Exception("TeleFone tem somente numeros");
            }
        }
        return true;
    }

    private boolean ehUmNumero(char digito) {
        return Character.isDigit(digito);
    }

}
