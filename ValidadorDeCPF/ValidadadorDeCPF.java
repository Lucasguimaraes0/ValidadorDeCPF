package ValidadorDeCPF;

public class ValidadadorDeCPF {
    public static void main(String[] args) {
        String cpf = "11144477775";
  
        System.out.println("O CPF informado foi: " + cpf);

        //armazenar cada caractere em uma constante

        char S1 = cpf.charAt(0);
        char S2 = cpf.charAt(1);
        char S3 = cpf.charAt(2);
        char S4 = cpf.charAt(3);
        char S5 = cpf.charAt(4);
        char S6 = cpf.charAt(5);
        char S7 = cpf.charAt(6);
        char S8 = cpf.charAt(7);
        char S9 = cpf.charAt(8);

        //converter cada caractere para inteiro

        int N1 = Character.getNumericValue(S1);
        int N2 = Character.getNumericValue(S2);
        int N3 = Character.getNumericValue(S3);
        int N4 = Character.getNumericValue(S4);
        int N5 = Character.getNumericValue(S5);
        int N6 = Character.getNumericValue(S6);
        int N7 = Character.getNumericValue(S7);
        int N8 = Character.getNumericValue(S8);
        int N9 = Character.getNumericValue(S9);

        //Cálculo dos dígitos verificadores:
        //Primeiro dígito verificador com a seguinte regra: verificador1 = (( N1 * 10) + (N2 * 9 ) + (N3 * 8) + ... + (N9 * 2))
        //Calcula-se o resto da divisão de verificador1 por 11 (resto1 = verificador1 % 11)
        //Se o resto1 for igual a 0 ou 1, o primeiro número verificador é igual a 0 (zero)
        //Se o resto1 for igual a 2,3,4,5,6,7,8,9 ou 10, o primeiro número verificador é igual a (11 - resto1)

        int verificador1 = ((N1 * 10) + (N2 * 9) + (N3 * 8) + (N4 * 7) + (N5 * 6) + (N6 * 5) + (N7 * 4) + (N8 * 3) + (N9 * 2));

        int resto1 = verificador1 % 11;

        int numVerificador1;

        if (resto1 == 0 || resto1 == 1){
            numVerificador1 = 0;
        } else{
            numVerificador1 = 11 - resto1;
        }

        //Cálculo do segundo dígito verificador:
        //De forma análoga ao cálculo do primeiro dígito verificador, adicionamos o numVerificador1 no cálculo e o número a multiplicar os N
        //Números inicia-se em 11

        int verificador2 = ((N1 * 11) + (N2 * 10) + (N3 * 9) + (N4 * 8) + (N5 * 7) + (N6 * 6) + (N7 * 5) + (N8 * 4) + (N9 * 3) + (numVerificador1 * 2));

        int resto2 = verificador2 % 11;

        int numVerificador2;

        if (resto2 == 0 || resto2 == 1){
            numVerificador2 = 0;
        } else{
            numVerificador2 = 11 - resto2;
        }

        //formato correto do cpf

        String cpf_corrigido = cpf.substring(0, cpf.length() - 2) + numVerificador1 + numVerificador2;

        //verificar se o cpf informado é válido ou não, caso negativo, mostrar o cpf corrigido
        
        if (cpf.equals(cpf_corrigido)){
            System.out.println("O CPF informado é válido!");
        } else {
            System.out.println("O CPF informado é inválido! O CPF corrigido é: " + cpf_corrigido);
        }

    }
}
