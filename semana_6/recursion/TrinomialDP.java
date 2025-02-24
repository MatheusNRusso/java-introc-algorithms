public class TrinomialDP {

    /**
     * Calcula o coeficiente trinomial T(n, k) usando programação dinâmica.
     * - T(n, k) representa o número de caminhos em uma grade triangular que começam no topo
     *   e terminam na posição (n, k).
     * - A fórmula recursiva é:
     *   T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)
     * - Restrições:
     *   - n >= 0
     *   - -n <= k <= n
     */
    public static long trinomial(int n, int k) {
        // Cria um array 2D para armazenar os valores intermediários.
        // dp[i][j] representa T(i, j-n), onde j está ajustado para evitar índices negativos.
        long[][] dp = new long[n + 1][2 * n + 1];

        // Caso base: T(0, 0) = 1
        dp[0][n] = 1;

        // Preenche a tabela dp usando a fórmula recursiva.
        for (int i = 1; i <= n; i++) {
            for (int j = -i; j <= i; j++) {
                // Calcula os três termos da fórmula recursiva:
                // T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)

                // Termo esquerdo: T(n-1, k-1)
                long left = (j - 1 + n >= 0) ? dp[i - 1][j - 1 + n] : 0;

                // Termo do meio: T(n-1, k)
                long middle = dp[i - 1][j + n];

                // Termo direito: T(n-1, k+1)
                long right = (j + 1 + n < 2 * n + 1) ? dp[i - 1][j + 1 + n] : 0;

                // Soma os três termos e armazena em dp[i][j+n]
                dp[i][j + n] = left + middle + right;
            }
        }

        // Retorna o valor T(n, k), ajustando o índice para evitar negativos.
        return dp[n][k + n];
    }

    /**
     * Método principal que lê os argumentos da linha de comando e imprime o coeficiente trinomial.
     * - Verifica se k está dentro dos limites válidos (-n <= k <= n).
     * - Se k estiver fora dos limites, imprime 0.
     * - Caso contrário, calcula e imprime T(n, k).
     */
    public static void main(String[] args) {
        // Lê os valores de n e k da linha de comando.
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        // Verifica se k está dentro dos limites válidos.
        if (k < -n || k > n) {
            System.out.println(0); // Fora dos limites, o coeficiente é 0.
        } else {
            // Calcula e imprime o coeficiente trinomial T(n, k).
            System.out.println(trinomial(n, k));
        }
    }
}
