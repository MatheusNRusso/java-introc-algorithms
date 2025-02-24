public class Minesweeper {
    public static void main(String[] arg) {
        int m = Integer.parseInt(arg[0]); // Número de linhas
        int n = Integer.parseInt(arg[1]); // Número de colunas
        int k = Integer.parseInt(arg[2]); // Número de minas

        int somaMinas = k;
        boolean[][] contemMina = new boolean[m + 2][n + 2];
        int[][] minaAdjunta = new int[m + 2][n + 2];

        // Posiciona as minas aleatoriamente
        while (somaMinas > 0) {
            int x = 1 + (int) (Math.random() * m);
            int y = 1 + (int) (Math.random() * n);

            if (!contemMina[x][y]) {
                contemMina[x][y] = true;
                somaMinas--;
            }
        }

        // Calcula o número de minas adjacentes
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!contemMina[i][j]) {
                    int minas = 0;
                    for (int r = i - 1; r <= i + 1; r++) {
                        for (int p = j - 1; p <= j + 1; p++) {
                            if (contemMina[r][p]) {
                                minas++;
                            }
                        }
                    }
                    minaAdjunta[i][j] = minas;
                } else {
                    minaAdjunta[i][j] = -1; // Indica que há uma mina
                }
            }
        }

        // Exibe o tabuleiro
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (minaAdjunta[i][j] < 0) {
                    System.out.print((j == 1 ? "" : " ") + "*" + (j == n ? "" : " "));
                } else {
                    System.out.print((j == 1 ? "" : " ") + minaAdjunta[i][j] + (j == n ? "" : " "));
                }
            }
            System.out.println();
        }
    }
}
