package apis.ifba.consultorio_api.interfaces;

public interface ValidacaodeCPF {

    public default void validaCPF(String cpf) throws Exception {
        if (cpf.length() != 11) {
            throw new Exception("CPF invalido");
        }
        temSomenteNumeros(cpf);
        validaPrimeiroDigitoVerificador(cpf);
    }

    private void temSomenteNumeros(String cpf) throws Exception {
        for (int i = 0; i < 9; i++) {
            ehUmDigito(cpf.charAt(i));
        }
    }

    private void ehUmDigito(char character) throws Exception {
        if (!Character.isDigit(character)) {
            throw new Exception("CPF deve conter somente numeros");
        }
    }

    private void validaPrimeiroDigitoVerificador(String cpf) throws Exception {
        for (int posicaoDoDigitoVerificador = 9; posicaoDoDigitoVerificador < 11; posicaoDoDigitoVerificador++) {
            calculoDosDigitosVerificadores(posicaoDoDigitoVerificador, cpf);
        }
    }

    default void calculoDosDigitosVerificadores(int posicaoDoDigitoVerificador, String cpf) throws Exception {
        int soma = 0;
        System.out.println("char at " + cpf.charAt(posicaoDoDigitoVerificador));
        final int digitoverificador = cpf.charAt(posicaoDoDigitoVerificador) - 48;
        System.out.println(digitoverificador);
        for (int i = 0; i < posicaoDoDigitoVerificador; i++) {
            soma += (cpf.charAt(i) - 48) * (posicaoDoDigitoVerificador + 1 - i);
        }
        final int restoDaDivisao = soma % 11;
        System.out.println("digito" + digitoverificador);
        System.out.println("resto" + restoDaDivisao);
        if (restoDaDivisao < 2) {
            digitoMenorQueDois(restoDaDivisao);
            return;
        }
        digitoMaiorQueDois(restoDaDivisao, digitoverificador);
    }

    private void digitoMenorQueDois(int resto) throws Exception {
        if (!(resto == 0)) {
            throw new Exception("Digito verificador invalido");
        }
    }

    private void digitoMaiorQueDois(int resto, final int digitoverificador) throws Exception {
        if (!((11 - resto) == digitoverificador)) {
            throw new Exception("Digito verificador invalido");
        }
    }

}