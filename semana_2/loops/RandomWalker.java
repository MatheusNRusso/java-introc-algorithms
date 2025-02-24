public class RandomWalker {
    public static void main(String[] args) {
        // Lê o argumento da linha de comando
        int r = Integer.parseInt(args[0]); // Distância limite da origem

        int x = 0, y = 0; // Coordenadas do ponto atual
        int steps = 0; // Contador de passos

        // Executa o movimento aleatório até alcançar a distância r da origem
        while (Math.abs(x) + Math.abs(y) < r) {
            // Exibe a posição atual
            System.out.println("(" + x + ", " + y + ")");

            // Gera um número aleatório entre 0 e 1
            double pass = Math.random();

            // Movimenta-se para uma das 4 direções (cima, baixo, esquerda, direita)
            if (pass > 0.75) {
                x += 1; // Direita
            } else if (pass > 0.5) {
                x -= 1; // Esquerda
            } else if (pass > 0.25) {
                y += 1; // Cima
            } else {
                y -= 1; // Baixo
            }

            // Incrementa o contador de passos
            steps++;
        }

        // Exibe a posição final e o número total de passos
        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
