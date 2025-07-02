import java.util.Scanner;
public class ConselhoJedi {
    final static Scanner sc = new Scanner(System.in);

    public static int[] mergeSortRec(int[] vetor, int inicio, int fim) {
        int meio;
        if(inicio < fim - 1) {
            meio = (inicio + fim) / 2;         
            vetor = mergeSortRec(vetor, inicio, meio);
            vetor = mergeSortRec(vetor, meio, fim);
            doMerge(vetor, inicio, meio, fim);
        }
        return vetor;
    }

    public static int[] doMerge(int[] vetor, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio;
        int k = 0;
        int[] vetorAux = new int[fim - inicio];

        while (i < meio && j < fim) {
            if (vetor[i] <= vetor[j]) {
                vetorAux[k] = vetor[i];
                k++;
                i++;
            }
            else {
                vetorAux[k] = vetor[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            vetorAux[k] = vetor[i];
            k++;
            i++;
        }
        
        while (j < fim) {
            vetorAux[k] = vetor[j];
            k++;
            j++;
        }

        for (int l = inicio; l < fim; l++) {
            vetor[l] = vetorAux[l - inicio];
        }
        return vetor;
    } 

    public static int encontrarSomaDasMaioresForcas(int[]vetForca, int n, int k) {
        int soma = 0; 
        mergeSortRec(vetForca, 0, vetForca.length);
        for (int i = vetForca.length - 1; i >= k; i--) {
            soma += vetForca[i];
        }
        return soma;
    }

    public static int[] preencherVetForca(int[] vetForca) {
        for (int i = 0; i < vetForca.length; i++) {
            vetForca[i] = sc.nextInt();
        }
        return vetForca;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] vetForca = new int[n];
        
        preencherVetForca(vetForca);
        int somaDeForcas = encontrarSomaDasMaioresForcas(vetForca, n, k);
        System.out.println(somaDeForcas);
    }
}
