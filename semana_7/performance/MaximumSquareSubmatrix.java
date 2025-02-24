public class MaximumSquareSubmatrix {

    /**
     * Calcula o tamanho da maior submatriz quadrada contígua composta apenas de 1s.
     * - Usa programação dinâmica (Dynamic Programming - DP) para resolver o problema.
     * - A matriz dp[i][j] armazena o tamanho da maior submatriz quadrada que termina na posição (i, j).
     */
    public static int size(int[][] a) {
        int n = a.length; // Tamanho da matriz (n x n).
        int[][] dp = new int[n][n]; // Matriz auxiliar para programação dinâmica.
        int maxSize = 0; // Armazena o tamanho máximo encontrado.

        // Preenche a matriz dp usando a fórmula recursiva.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) { // Verifica se o elemento atual é 1.
                    if (i == 0 || j == 0) {
                        // Caso base: se estiver na primeira linha ou coluna, dp[i][j] = 1.
                        dp[i][j] = 1;
                    } else {
                        // Fórmula recursiva:
                        // O tamanho da submatriz quadrada que termina em (i, j) depende dos valores
                        // nas posições (i-1, j), (i, j-1) e (i-1, j-1).
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // Atualiza o tamanho máximo encontrado.
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize; // Retorna o tamanho máximo da submatriz quadrada.
    }

    /**
     * Método principal que lê uma matriz da entrada padrão e imprime o tamanho da maior submatriz quadrada.
     * - Lê o tamanho da matriz (n) e os elementos da matriz.
     * - Chama o método size para calcular o tamanho da maior submatriz quadrada.
     * - Imprime o resultado.
     */
    public static void main(String[] args) {
        int n = StdIn.readInt(); // Lê o tamanho da matriz (n x n).
        int[][] resultado = new int[n][n]; // Cria a matriz para armazenar os valores.

        // Lê os elementos da matriz.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = StdIn.readInt();
            }
        }

        // Calcula e imprime o tamanho da maior submatriz quadrada.
        System.out.println(size(resultado));
    }
}
