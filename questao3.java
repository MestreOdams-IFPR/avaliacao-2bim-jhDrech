public class questao3 {
    public static int pell(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        return (2 * pell(n - 1)) + pell(n - 2);
    }
    public static void main(String[] args) {
        int p = pell(9);
        System.out.println(p);
    }
}
