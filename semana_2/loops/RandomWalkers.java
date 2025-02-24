public class RandomWalkers {
    public static void main(String[] arg) {
        // Lê os argumentos da linha de comando
        int r = Integer.parseInt(arg[0]); // Distância limite da origem
        int trials = Integer.parseInt(arg[1]); // Número de tentativas

        int sum = 0; // Variável para armazenar o total de passos

        // Executa múltiplas simulações do caminhante aleatório
        for (int i = 0; i < trials; i++) {
            int x = 0, y = 0; // Coordenadas do ponto atual
            int steps = 0; // Contador de passos

            // Caminha até atingir a distância de Manhattan r
            while (Math.abs(x) + Math.abs(y) < r) {
                double p = Math.random(); // Gera um número aleatório entre 0 e 1

                // Movimenta-se para uma das 4 direções (cima, baixo, esquerda, direita)
                if (p > 0.75) {
                    x += 1; // Direita
                } else if (p > 0.5) {
                    x -= 1; // Esquerda
                } else if (p > 0.25) {
                    y += 1; // Cima
                } else {
                    y -= 1; // Baixo
                }

                steps++; // Incrementa o contador de passos
            }

            sum += steps; // Acumula o total de passos
        }

        // Calcula a média dos passos
        double average = sum / (double) trials;

        // Exibe o resultado final
        System.out.println("average number of steps = " + average);
    }
}
