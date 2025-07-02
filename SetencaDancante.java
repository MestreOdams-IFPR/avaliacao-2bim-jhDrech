import java.util.Scanner;

public class SetencaDancante {
    final static Scanner sc = new Scanner(System.in);

    public static String transformarEmDancante(String palavra) {
        char[] arrayPalavra = palavra.toCharArray();
        arrayPalavra[0] = Character.toUpperCase(arrayPalavra[0]);
        boolean maiusculo = true;
        for (int i = 1; i < arrayPalavra.length; i++) {
            if (!maiusculo && (int)arrayPalavra[i] != 32) {
                arrayPalavra[i] = Character.toUpperCase(arrayPalavra[i]);
                maiusculo = true;
            }
            else if((int)arrayPalavra[i] != 32) {
                maiusculo = false;
            }
        } 
        String palavraDancante = "";
        for (int i = 0; i < arrayPalavra.length; i++) {
            palavraDancante += arrayPalavra[i];
        }
        return palavraDancante;
    }
    public static void main(String[] args) {
        String palavra = sc.nextLine();
        String palavraDancante = transformarEmDancante(palavra);
        System.out.println(palavraDancante);
    }
}
