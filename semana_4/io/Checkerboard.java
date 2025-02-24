public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // Tamanho do tabuleiro (n x n)
        StdDraw.setScale(0, n); // Define a escala do desenho

        // Percorre as células do tabuleiro
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Define a cor baseada na posição (padrão xadrez)
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                // Desenha um quadrado preenchido na posição correta
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
