public class RevesPuzzle {

    // Função para calcular o valor ótimo de k
    private static int calculateK(int n) {
        return (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
    }

    // Função recursiva para resolver o problema das Torres de Hanói com 3 pinos
    private static void hanoi(int discs, char start, char end, char auxiliary) {
        if (discs == 1) {
            System.out.println("Move disc 1 from " + start + " to " + end);
            return;
        }
        hanoi(discs - 1, start, auxiliary, end); // Move n-1 discos para o pino auxiliar
        System.out.println("Move disc " + discs + " from " + start + " to " + end); // Move o maior disco para o destino
        hanoi(discs - 1, auxiliary, end, start); // Move os n-1 discos do auxiliar para o destino
    }

    // Função recursiva para resolver o problema de Reve (4 pinos)
    private static void reves(int discs, char start, char end, char auxiliary1, char auxiliary2) {
        if (discs == 0) {
            return;
        }
        if (discs == 1) {
            System.out.println("Move disc 1 from " + start + " to " + end);
            return;
        }

        int k = calculateK(discs); // Calcula o valor ótimo de k

        // Passo 1: Move os k menores discos para o pino auxiliar1 (usando todos os 4 pinos)
        reves(k, start, auxiliary1, auxiliary2, end);

        // Passo 2: Move os discos restantes (n - k) para o pino de destino (usando 3 pinos, excluindo auxiliary1)
        hanoi(discs - k, start, end, auxiliary2);

        // Passo 3: Move os k menores discos do pino auxiliar1 para o pino de destino (usando todos os 4 pinos)
        reves(k, auxiliary1, end, start, auxiliary2);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RevesPuzzle <number_of_discs>");
            return;
        }

        int n = Integer.parseInt(args[0]); // Número de discos
        char start = 'A'; // Pino inicial
        char end = 'D'; // Pino de destino
        char auxiliary1 = 'B'; // Primeiro pino auxiliar
        char auxiliary2 = 'C'; // Segundo pino auxiliar

        // Resolver o problema de Reve
        reves(n, start, end, auxiliary1, auxiliary2);
    }
}
