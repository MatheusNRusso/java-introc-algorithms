public class TrinomialBrute {

    /**
     * Calcula o coeficiente trinomial T(n, k) usando recursão.
     * - T(n, k) representa o número de caminhos em uma grade triangular que começam no topo
     *   e terminam na posição (n, k).
     * - A fórmula recursiva é:
     *   T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)
     * - Restrições:
     *   - n >= 0
     *   - -n <= k <= n
     */
    public static long trinomial(int n, int k) {
        // Caso base: T(0, 0) = 1
        if (n == 0 && k == 0)
            return 1;

        // Caso base: Fora dos limites válidos (-n <= k <= n)
        if (k < -n || k > n)
            return 0;

        // Fórmula recursiva:
        // T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

    /**
     * Método principal que lê os argumentos da linha de comando e imprime o coeficiente trinomial.
     * - Lê os valores de n e k da linha de comando.
     * - Chama a função trinomial para calcular T(n, k).
     * - Imprime o resultado.
     */
    public static void main(String[] args) {
        // Lê os valores de n e k da linha de comando.
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        // Calcula e imprime o coeficiente trinomial T(n, k).
        System.out.println(trinomial(n, k));
    }
}
