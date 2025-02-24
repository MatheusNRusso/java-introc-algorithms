import java.awt.Color;

public class RecursiveSquares {

    // Constantes para evitar números "mágicos"
    private static final int CANVAS_SIZE = 800;
    private static final double CENTER_X = 0.5;
    private static final double CENTER_Y = 0.5;
    private static final double SIDE_LENGTH = 0.5;

    // Configura o canvas e a escala (chamado apenas uma vez no início)
    private static void setupCanvas() {
        StdDraw.setCanvasSize(CANVAS_SIZE, CANVAS_SIZE);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
    }

    // Desenha um quadrado centralizado em (x, y) com o comprimento do lado dado
    public static void drawSquare(double x, double y, double length) {
        double halfLength = length / 2.0;

        // Define a cor de fundo como cinza claro
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, halfLength);

        // Define a cor da borda como preta
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.square(x, y, halfLength);
    }

    // Desenha um padrão recursivo de quadrados de ordem n, centralizado em (x, y)
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) {
            return; // Caso base: parar a recursão quando n for 0
        }

        // Desenha o quadrado atual
        drawSquare(x, y, length);

        // Calcula metade do comprimento do lado para os quadrados menores
        double halfLength = length / 2.0;

        // Desenha recursivamente os quatro quadrados menores nos cantos
        draw(n - 1, x - halfLength, y + halfLength, halfLength); // Canto superior esquerdo
        draw(n - 1, x + halfLength, y + halfLength, halfLength); // Canto superior direito
        draw(n - 1, x - halfLength, y - halfLength, halfLength); // Canto inferior esquerdo
        draw(n - 1, x + halfLength, y - halfLength, halfLength); // Canto inferior direito
    }

    // Método principal para desenhar o padrão de quadrados recursivos
    public static void main(String[] args) {
        if (args.length != 1) {
            return; // Não imprime mensagens de erro no console
        }

        int n = Integer.parseInt(args[0]); // Ordem do padrão recursivo

        // Configura o canvas e a escala
        setupCanvas();

        // Desenha o padrão de quadrados recursivos
        draw(n, CENTER_X, CENTER_Y, SIDE_LENGTH);
    }
}
